package org.usfirst.frc.team4019;

enum DriveMode {ARCADE, TANK, TWIST, TRIPLE, HYBRID, DS4_ARCADE, DS4_TANK}

public abstract class Drive {
	static DriveMode driveMode = DriveMode.ARCADE;

	static double[] arcadeDrive() {
		double forward = Robot.rightStick.getY() * Robot.rightStick.getThrottle();
		double rotation = Robot.rightStick.getX() * Robot.rightStick.getThrottle();
		return new double[] {forward + rotation, forward - rotation};
	}

	static double[] tankDrive() {
		double left = Robot.leftStick.getY() * Robot.rightStick.getThrottle();
		double right = Robot.rightStick.getY() * Robot.rightStick.getThrottle();
		return new double[] {left, right};
	}

	static double[] hybridDrive() {
		return new double[] {0, 0};
	}

	static double[] twistDrive() {
		double forward = Robot.rightStick.getY() * Robot.rightStick.getThrottle();
		double rotation = Robot.rightStick.getTwist() * Robot.rightStick.getThrottle();
		return new double[] {forward + rotation, forward - rotation};
	}

	static double[] tripleDrive() {
		return new double[] {0, 0};
	}

	static double[] ds4ArcadeDrive() {
		double forward = Robot.rightStick.getY() * Dashboard.getSlider(0) / 5;
		double rotation = Robot.rightStick.getX() * Dashboard.getSlider(0) / 5;
		return new double[] {forward + rotation, forward - rotation};
	}

	static double[] ds4TankDrive() {
		double throttle = (1 - Dashboard.getSlider(0) / 5) / 2;
		double leftThrottle = (-Robot.rightStick.getRawAxis(3) * throttle) + (1 - throttle);
		double rightThrottle = (-Robot.rightStick.getRawAxis(4) * throttle) + (1 - throttle);
		double left = -Robot.rightStick.getRawAxis(1) * leftThrottle;
		double right = -Robot.rightStick.getRawAxis(5) * rightThrottle;
		return new double[] {left, right};
	}
}