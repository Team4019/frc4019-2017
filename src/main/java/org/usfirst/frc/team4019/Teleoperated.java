package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Relay;

public abstract class Teleoperated {
	public static int init() {
		return 0;
	}

	public static int periodic() {
		// Drive and align
		if (Robot.rightStick.button(Constants.drive.arcadeButton)) {
			Robot.drive.mode = Drive.DriveMode.ARCADE;
		} else if (Robot.rightStick.button(Constants.drive.hybridButton)) {
			Robot.drive.mode = Drive.DriveMode.HYBRID;
		} else if (Robot.rightStick.button(Constants.drive.twistButton)) {
			Robot.drive.mode = Drive.DriveMode.TWIST;
		} else if (Robot.rightStick.button(Constants.drive.tripleButton)) {
			Robot.drive.mode = Drive.DriveMode.TRIPLE;
		}
		if (!Assist.assist(Robot.rightStick.button(Constants.assist.distanceButton), Robot.rightStick.button(Constants.assist.angleButton))) {
			Robot.drive.drive();
		}

		// Ball intake
		if (Robot.leftStick.button(Constants.intake.forwardButton)) {
			Robot.intake.forward();
		} else if (Robot.leftStick.button(Constants.intake.reverseButton)) {
			Robot.intake.reverse();
		} else {
			Robot.intake.stop();
		}

		// Conveyor and shooter
		if (Robot.leftStick.anyButton(Constants.shooter.constantButton, Constants.shooter.dynamicButton, Constants.shooter.manualButton)) {
			if (Robot.leftStick.button(Constants.shooter.constantButton)) {
				Robot.shooter.constant();
			} else if (Robot.leftStick.button(Constants.shooter.dynamicButton)) {
				Robot.shooter.dynamic();
			} else if (Robot.leftStick.button(Constants.shooter.manualButton)) {
				Robot.shooter.set(Robot.leftStick.throttle());
			}
			Robot.conveyor.start();
		} else if (Robot.leftStick.button(Constants.conveyor.reverseButton)) {
			Robot.shooter.stop();
			Robot.conveyor.reverse();
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