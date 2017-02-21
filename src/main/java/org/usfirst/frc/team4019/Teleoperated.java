package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Teleoperated {
	public static int init() {
		CameraServer.getInstance().startAutomaticCapture();
		return 0;
	}

	public static int periodic() {

		// DRIVE AND ALIGN
		if (!(Robot.rightStick.getRawButton(Constants.alignment.movementButton) || Robot.rightStick.getRawButton(Constants.alignment.rotationButton))) {
			Robot.drive.arcadeDrive(-Robot.rightStick.getY(), Robot.rightStick.getX(), (Robot.rightStick.getThrottle() - 1) / -2);
		} else {

		}

		// SCAVENGER
		if (Robot.leftStick.getRawButton(Constants.scavenger.intakeButton)) {
			Robot.scavenger.start();
		} else if (Robot.leftStick.getRawButton(Constants.scavenger.outtakeButton)) {
			Robot.scavenger.reverse();
		} else {
			Robot.scavenger.stop();
		}

		// CONVEYOR AND SHOOTER
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

		// CLIMB
		if (Robot.leftStick.getRawButton(Constants.climb.leftSafetyButton) && Robot.rightStick.getRawButton(Constants.climb.rightSafetyButton)) {
			Robot.climb.set(Robot.leftStick.getY());
		} else {
			Robot.climb.stop();
		}

		return 0;
	}
}