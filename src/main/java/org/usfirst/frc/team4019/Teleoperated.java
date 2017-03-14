package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Relay;

public abstract class Teleoperated {
	public static int init() {
		return 0;
	}

	public static int periodic() {
		// Drive and align
		if (!(Robot.rightStick.getRawButton(Constants.assist.distanceButton) || Robot.rightStick.getRawButton(Constants.assist.angleButton))) {
			Robot.drive.drive(-Robot.rightStick.getY(), Robot.rightStick.getX(), (Robot.rightStick.getThrottle() - 1) / -2);
		} else {
			Assist.assist(Robot.rightStick.getRawButton(Constants.assist.distanceButton), Robot.rightStick.getRawButton(Constants.assist.angleButton));
		}

		// Ball intake
		if (Robot.leftStick.getRawButton(Constants.intake.forwardButton)) {
			Robot.intake.start();
		} else if (Robot.leftStick.getRawButton(Constants.intake.reverseButton)) {
			Robot.intake.reverse();
		} else {
			Robot.intake.stop();
		}

		// Conveyor and shooter
		if (Robot.leftStick.getRawButton(Constants.shooter.safetyButton)) {
			Robot.shooter.set((Robot.leftStick.getThrottle() - 1) / -2);
			if (!Robot.leftStick.getRawButton(Constants.conveyor.invertButton)) {
				Robot.conveyor.start();
			} else {
				Robot.conveyor.reverse();
			}
		} else {
			Robot.shooter.stop((Robot.leftStick.getThrottle() - 1) / -2);
			Robot.conveyor.stop();
		}

		// Climbing mechanism
		if (Robot.leftStick.getRawButton(Constants.climber.safetyButton)) {
			Robot.climber.set(Robot.leftStick.getY());
		} else {
			Robot.climber.stop();
		}
		Robot.climber.setDashboard(Robot.leftStick.getRawButton(Constants.climber.safetyButton), -Robot.leftStick.getY());

		// LED lights
		Robot.lights.set(Dashboard.getButton(0) ? Relay.Value.kOn : Relay.Value.kOff);

		return 0;
	}
}