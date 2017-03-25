package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Relay;

public abstract class Teleoperated {
	static Double shooterStart = null;

	static double now() {
		return System.currentTimeMillis() / 1000.0;
	}

	public static int init() {
		return 0;
	}

	public static int periodic() {
		// Drive and align
		double driveThrottle = Robot.rightStick.throttle();
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
			Robot.drive.drive(driveThrottle);
		}
		Dashboard.write(Constants.drive.dashboard, "Drive: " + Robot.drive.mode + " " + Math.round(driveThrottle * 100) + "%");

		// Ball intake
		if (Robot.leftStick.button(Constants.intake.forwardButton)) {
			Robot.intake.forward();
		} else if (Robot.leftStick.button(Constants.intake.reverseButton)) {
			Robot.intake.reverse();
		} else {
			Robot.intake.stop();
		}
		Dashboard.write(Constants.intake.dashboard, "Intake: " + Robot.intake.mode);

		// Shooting mechanism
		double shooterThrottle = Range.spread(Robot.leftStick.throttle(), Dashboard.getSlider(0) / 100, Dashboard.getSlider(1) / 100);
		if (Robot.leftStick.button(Constants.shooter.constantButton)) {
			if (shooterStart == null) shooterStart = now();
			Robot.shooter.constant();
		} else if (Robot.leftStick.button(Constants.shooter.dynamicButton)) {
			if (shooterStart == null) shooterStart = now();
			Robot.shooter.dynamic();
		} else if (Robot.leftStick.button(Constants.shooter.manualButton)) {
			if (shooterStart == null) shooterStart = now();
			Robot.shooter.set(shooterThrottle);
		} else {
			shooterStart = null;
			Robot.shooter.stop();
		}
		Dashboard.write(Constants.shooter.dashboard, "Shooter: " + Robot.shooter.mode + " " + Math.round(shooterThrottle * 100) + "%");

		// Shooting mechanism conveyor
		if ((shooterStart != null && now() > shooterStart + Constants.conveyor.startupTime) || Robot.leftStick.button(Constants.conveyor.forwardButton)) {
			Robot.conveyor.forward();
		} else if (Robot.leftStick.button(Constants.conveyor.reverseButton)) {
			Robot.conveyor.reverse();
		} else {
			Robot.conveyor.stop();
		}
		Dashboard.write(Constants.conveyor.dashboard, "Conveyor: " + Robot.conveyor.mode);

		// Climbing mechanism
		double climberThrottle = Robot.leftStick.vertical();
		if (Robot.leftStick.button(Constants.climber.safetyButton)) {
			Robot.climber.set(climberThrottle);
		} else {
			Robot.climber.stop();
		}
		Dashboard.write(Constants.climber.dashboard, "Climber: " + Robot.climber.mode + " " + Math.round(climberThrottle * 100) + "%");

		// LED lights
		Robot.lights.set(Dashboard.getButton(0) ? Relay.Value.kOn : Relay.Value.kOff);

		return 0;
	}
}