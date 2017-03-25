package org.usfirst.frc.team4019;

import java.util.Date;

public abstract class Autonomous {
	static double initial;
	static double time;
	static double delta;
	static int stage;

	static double now() {
		return System.currentTimeMillis() / 1000.0;
	}

	public static int init() {
		initial = now();
		time = 0;
		return 0;
	}

	public static int periodic() {
		delta = now() - initial - time;
		time += delta;

		/*if (time < Constants.autonomous.forwardTime) {
			Robot.drive.set(Constants.autonomous.forwardSpeed, 0);
		} else if (time < Constants.autonomous.forwardTime + Constants.autonomous.rotationTime) {
			Robot.drive.set(0, Constants.autonomous.rotationSpeed * Constants.autonomous.polarity);
		} else if (time < Constants.autonomous.forwardTime + Constants.autonomous.rotationTime + Constants.autonomous.lateralTime) {
			Robot.drive.set(Constants.autonomous.lateralSpeed, 0);
		} else if (time < Constants.autonomous.forwardTime + Constants.autonomous.rotationTime + Constants.autonomous.lateralTime + Constants.autonomous.alignTime) {
			Robot.drive.set(0, Constants.autonomous.alignSpeed * Constants.autonomous.polarity);
		} else {
			Robot.shooter.set(Constants.autonomous.shooterSpeed);
		}*/

		return 0;
	}
}