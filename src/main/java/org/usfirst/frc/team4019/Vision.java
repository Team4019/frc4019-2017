package org.usfirst.frc.team4019;

import org.opencv.core.Mat;

public abstract class Vision {
	static GripPipeline gripPipeline = new GripPipeline();
	static Mat source = new Mat();
	static Mat filtered = new Mat();

	public static void filter() {
		gripPipeline.process(source);
		filtered = gripPipeline.cvErodeOutput();
	}

	public static void process() {
		// Pixels start in the top left corner of the viewport.
		// 255 for on, 0 for off.
		int off = 0;
		int on = 0;
		for (int y = 0; y < filtered.cols(); y++) {
			for (int x = 0; x < filtered.rows(); x++) {
				if (filtered.get(x, y)[0] == 0) {
					off++;
				} else {
					on++;
				}
			}
		}
		System.out.println(Integer.toString(on) + " " + Integer.toString(off));
	}
}