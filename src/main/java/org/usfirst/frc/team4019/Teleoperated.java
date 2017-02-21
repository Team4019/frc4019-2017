package org.usfirst.frc.team4019;

public abstract class Teleoperated {
	public static int init() {
		Vision.start();
		return 0;
	}

	public static int periodic() {
		/*switch (Robot.rightStick.getPOV()) {
			case 0:
				Drive.driveMode = DriveMode.DS4_TANK;
				break;
			case 45:
				break;
			case 90:
				Drive.driveMode = DriveMode.DS4_ARCADE;
				break;
			case 135:
				break;
			case 180:
				Drive.driveMode = DriveMode.HYBRID;
				break;
			case 225:
				break;
			case 270:
				Drive.driveMode = DriveMode.TANK;
				break;
			case 315:
				break;
		}*/
		switch (Robot.rightStick.rawButton()) {
			case 7:
				Drive.driveMode = DriveMode.ARCADE;
				break;
			case 8:
				Drive.driveMode = DriveMode.HYBRID;
				break;
			case 9:
				Drive.driveMode = DriveMode.TWIST;
				break;
			case 10:
				Drive.driveMode = DriveMode.TRIPLE;
				break;
			case 11:
				Drive.driveMode = DriveMode.TANK;
				break;
		}

		double[] speeds = {0, 0};
		switch (Drive.driveMode) {
			case ARCADE:
				speeds = Drive.arcadeDrive();
				break;
			case HYBRID:
				speeds = Drive.hybridDrive();
				break;
			case TWIST:
				speeds = Drive.twistDrive();
				break;
			case TRIPLE:
				speeds = Drive.tripleDrive();
				break;
			case TANK:
				speeds = Drive.tankDrive();
				break;
			case DS4_ARCADE:
				speeds = Drive.ds4ArcadeDrive();
				break;
			case DS4_TANK:
				speeds = Drive.ds4TankDrive();
				break;
		}

		// Auto adjust (Work in progress)
		if (Robot.rightStick.getRawButton(3) && Vision.boilerAngle.value != null) {
			/*if (Vision.boilerAngle.value < -10) {
				Drive.setMotors(0.2, -0.2);
			} else if (Vision.boilerAngle.value < -2) {
				Drive.setMotors(0.15, -0.15);
			} else if (Vision.boilerAngle.value > 10) {
				Drive.setMotors(-0.2, 0.2);
			} else if (Vision.boilerAngle.value > 2) {
				Drive.setMotors(-0.15, 0.15);
			}*/
			if (Math.abs(Vision.boilerAngle.value) > 2.5) {
				//Drive.setMotors(Vision.boilerAngle.value * -0.025, Vision.boilerAngle.value * 0.025);
				speeds[0] += Math.cbrt(Vision.boilerAngle.value) * -0.075;
				speeds[1] += Math.cbrt(Vision.boilerAngle.value) * 0.075;
			}
		}
		if (Robot.rightStick.getRawButton(5) && Vision.boilerDistance.value != null) {
			if (Math.abs(Vision.boilerDistance.value - 72) > 1.5) {
				//double speed = Exponent.odd(Vision.boilerDistance.value - 72, 2) * 0.005;
				//speeds[0] += speed;
				//speeds[1] += speed;
			}
		}

		Dashboard.write(0, Drive.driveMode.toString());
		Dashboard.write(1, Robot.ultrasonic.getDistance().getString());
		Dashboard.write(2, Vision.boilerDistance.getString());
		Dashboard.write(3, Vision.boilerAngle.getString());
		Robot.drivetrain.set(speeds);

		return 0;
	}
}