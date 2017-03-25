package org.usfirst.frc.team4019;

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

		if (time < Constants.autonomous.time) Robot.drive.set(Constants.autonomous.speed, 0);

		/*if (time < Constants.autonomous.readyTime) {
			Robot.drive.set(Constants.autonomous.readySpeed, 0);
		} else if (time < Constants.autonomous.readyTime + Constants.autonomous.rotationTime) {
			Robot.drive.set(0, Constants.autonomous.rotationSpeed * Constants.autonomous.polarity);
		} else if (time < Constants.autonomous.readyTime + Constants.autonomous.rotationTime + Constants.autonomous.lateralTime) {
			Robot.drive.set(Constants.autonomous.lateralSpeed, 0);
		} else if (time < Constants.autonomous.readyTime + Constants.autonomous.rotationTime + Constants.autonomous.lateralTime + Constants.autonomous.alignTime) {
			Robot.drive.set(0, Constants.autonomous.alignSpeed * Constants.autonomous.polarity);
		} else {
			Robot.shooter.set(Constants.autonomous.shooterSpeed);
		}*/

		/*if (
				stage == 0 && time > Constants.autonomous.readyTime ||
				stage == 1 && time > Constants.autonomous.rotationTime ||
				stage == 2 && time > Constants.autonomous.lateralTime ||
				stage == 3 && time > Constants.autonomous.alignTime ||
				stage == 4 && time > Constants.autonomous.forwardTime ||
				stage == 5 && time > Constants.autonomous.shootTime ||
				stage == 6 && time > Constants.autonomous.reverseTime ||
				stage == 7 && time > Constants.autonomous.alignTime ||
				stage == 8 && time > Constants.autonomous.rotationTime ||
				stage == 9 && time > Constants.autonomous.finishTime
		) {
			stage += 1;
			initial = now();
		}

		switch (stage) {
			case 0:
				Robot.drive.set(Constants.autonomous.readySpeed, 0);
				break;
			case 1:
				Robot.drive.set(0, Constants.autonomous.rotationSpeed * Constants.autonomous.polarity);
				break;
			case 2:
				Robot.drive.set(Constants.autonomous.lateralSpeed, 0);
				break;
			case 3:
				Robot.drive.set(0, Constants.autonomous.alignSpeed * Constants.autonomous.polarity);
				break;
			case 4:
				Robot.drive.set(Constants.autonomous.forwardSpeed, 0);
				break;
			case 5:
				Robot.shooter.set(Constants.autonomous.shootPower);
				break;
			case 6:
				Robot.shooter.stop();
				Robot.drive.set(-Constants.autonomous.reverseSpeed, 0);
				break;
			case 7:
				Robot.drive.set(0, -Constants.autonomous.alignTime * Constants.autonomous.polarity);
				break;
			case 8:
				Robot.drive.set(0, -Constants.autonomous.rotationTime * Constants.autonomous.polarity);
				break;
			case 9:
				Robot.drive.set(Constants.autonomous.finishSpeed, 0);
				break;
			case 10:
				Robot.drive.stop();
				break;
		}*/

		return 0;
	}
}