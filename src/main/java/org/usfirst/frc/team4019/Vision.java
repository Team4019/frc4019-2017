package org.usfirst.frc.team4019;

import org.opencv.core.Point;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;
import java.util.List;
import java.util.ArrayList;

class VisionThread extends Thread {
	private Thread thread;
	public void start() {
		if (thread == null) {
			thread = new Thread(this, "Vision");
			thread.start();
			//System.out.println("Vision thread started");
		} else {
			//System.out.println("Vision thread already exists");
		}
	}
	public void interrupt() {
		if (thread != null) {
			thread.interrupt();
			thread = null;
		}
	}
	public void run() {
		try {
			while (true) {
				Vision.run();
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			//System.out.println("Vision thread interrupted");
		}
		thread = null;
		//System.out.println("Vision thread terminated");
	}
}

public abstract class Vision {
	static private int rotations = 16;
	static GripPipeline gripPipeline = new GripPipeline();
	static Mat source = new Mat();
	static Mat filtered = new Mat();
	static MatOfPoint boundary = null;
	static Integer minimum = null;
	static Integer maximum = null;
	static Double boilerRawDistance = null;
	static Double boilerDistance = null;
	static Double boilerAngle = null;
	static Double liftDistance = null;
	static VisionThread thread = new VisionThread();

	public static MatOfPoint largestContour(List<MatOfPoint> contours) {
		MatOfPoint result = null;
		double maximum = 0;
		for (MatOfPoint contour : contours) {
			double area = Imgproc.contourArea(contour);
			if (area > maximum) {
				result = contour;
				maximum = area;
			}
		}
		return result;
	}

	public static void filter() {
		gripPipeline.process(source);
		filtered = gripPipeline.hsvThresholdOutput();
		boundary = largestContour(gripPipeline.convexHullsOutput());
	}

	public static void trackBoiler() {
		// Unused code, use if processing standard images rather than contours.
		// Pixels forward in the top left corner of the viewport.
		// 255 for on, 0 for off.

		/*Integer min = null;
		for (int x = 0; x < filtered.cols(); x++) {
			for (int y = 0; y < filtered.rows(); y++) {
				if (filtered.get(y, x)[0] != 0) {
					min = x;
					break;
				}
			}
			if (min != null) break;
		}
		Integer max = null;
		for (int x = filtered.cols() - 1; x >= 0; x--) {
			for (int y = 0; y < filtered.rows(); y++) {
				if (filtered.get(y, x)[0] != 0) {
					max = x;
					break;
				}
			}
			if (max != null) break;
		}
		if (min != null && max != null) {
			boilerRawDistance = new Distance(Constants.boiler.width / 2 / Math.tan(Math.toRadians(Constants.camera.fov) * (max - min + 1) / Constants.camera.size[0] / 2));
		} else {
			boilerRawDistance = new Distance(null);
		}*/

		if (boundary != null && boundary.toArray().length > 0) {
			minimum = null;
			maximum = null;
			for (Point vertex : boundary.toArray()) {
				if (minimum == null || (minimum != null && vertex.x < minimum)) minimum = (int) vertex.x;
				if (maximum == null || (minimum != null && vertex.x > maximum)) maximum = (int) vertex.x;
			}
			boilerRawDistance = Constants.boiler.width / 2 / Math.tan(Math.toRadians(Constants.camera.fov) * (maximum - minimum + 1) / Constants.camera.size[0] / 2);
			boilerDistance = Math.sqrt(Math.max(Math.pow(boilerRawDistance, 2) - Math.pow(Constants.boiler.height - Constants.camera.height, 2), 0)) - Constants.camera.inset + (Constants.boiler.width / 2);
			boilerAngle = Constants.camera.fov * (0.5 - (double) (maximum + minimum) / 2 / Constants.camera.size[0]);
		} else {
			boilerRawDistance = null;
			boilerDistance = null;
			boilerAngle = null;
		}

		Dashboard.write(Constants.vision.distanceDashboard, (int) Math.round(boilerDistance) / 12 + "' " + (int) Math.round(boilerDistance) % 12 + "\"");
		Dashboard.write(Constants.vision.angleDashboard, (int) Math.round(boilerAngle) + " deg");
	}

	public static void trackLift() {
		// Unused code, use if processing standard images rather than contours.

		/*ArrayList<int[]> extremities = new ArrayList<>();
		double angle;
		for (int i = 0; i < rotations; i++) {
			angle = i * 2 * Math.PI / rotations;
			double current;
			Double maximum = null;
			int[] extremity = null;
			for (int y = 0; y < filtered.rows(); y++) {
				for (int x = 0; x < filtered.cols(); x++) {
					if (filtered.get(y, x)[0] != 0) {
						System.out.println("found pixel");
						current = y * Math.sin(angle) + x * Math.cos(angle);
						if (maximum == null || (maximum != null && current > maximum)) {
							maximum = current;
							extremity = new int[] {x, y};
							System.out.println("SET: " + Integer.toString(extremity[0]) + ", " + Integer.toString(extremity[1]));
						}
					}
				}
			}
			if (extremity != null) {
				extremities.add(extremity);
			}
		}*/

		ArrayList<int[]> extremities = new ArrayList<>();
		if (boundary != null && boundary.toArray().length > 0) {
			double angle;
			for (int i = 0; i < rotations; i++) {
				angle = i * 2 * Math.PI / rotations;
				double current;
				Double maximum = null;
				int[] extremity = null;
				for (Point vertex : boundary.toArray()) {
					current = vertex.y * Math.sin(angle) + vertex.x * Math.cos(angle);
					if (maximum == null || (maximum != null && current > maximum)) {
						maximum = current;
						extremity = new int[]{(int) vertex.x, (int) vertex.y};
					}
				}
				extremities.add(extremity);
			}
		}
	}

	public static void run() {
		Robot.video.grabFrame(source);
		filter();
		trackBoiler();
		Robot.stream.putFrame(filtered);
	}

	public static void start() {
		thread.start();
	}

	public static void interrupt() {
		thread.interrupt();
	}
}