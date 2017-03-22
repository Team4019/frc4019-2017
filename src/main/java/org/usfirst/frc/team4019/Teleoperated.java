package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Relay;

public abstract class Teleoperated {
	public static int init() {
		return 0;
	}

	public static int periodic() {
		// Drive and align
		if (!Assist.assist(Robot.rightStick.button(Constants.assist.distanceButton), Robot.rightStick.button(Constants.assist.angleButton))) {
			Robot.drive.drive(Robot.rightStick.vertical(), Robot.rightStick.horizontal(), Robot.rightStick.throttle());
		}

		// Ball intake
		if (Robot.leftStick.button(Constants.intake.forwardButton)) {
			Robot.intake.start();
		} else if (Robot.leftStick.button(Constants.intake.reverseButton)) {
			Robot.intake.reverse();
		} else {
			Robot.intake.stop();
		}

		// Conveyor and shooter
		if (Robot.leftStick.button(Constants.shooter.safetyButton)) {
			Robot.shooter.set(Robot.leftStick.throttle());
			if (!Robot.leftStick.button(Constants.conveyor.invertButton)) {
				Robot.conveyor.start();
			} else {
				Robot.conveyor.reverse();
			}
		} else {
			Robot.shooter.stop();
			Robot.conveyor.stop();
		}

		// Climbing mechanism
		if (Robot.leftStick.button(Constants.climber.safetyButton)) {
			Robot.climber.set(Robot.leftStick.vertical());
		} else {
			Robot.climber.stop();
		}

		// LED lights
		Robot.lights.set(Dashboard.getButton(0) ? Relay.Value.kOn : Relay.Value.kOff);

		return 0;
	}
}