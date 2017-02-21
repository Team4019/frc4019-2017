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

		System.out.println(Robot.leftStick.getThrottle() + " | " + Robot.rightStick.getThrottle());

		if (Robot.rightStick.getRawButton(1)) {
			Robot.conveyor.set(Robot.rightStick.getThrottle());
		} else {
			Robot.conveyor.stop();
		}
		if (Robot.leftStick.getRawButton(1)) {
			Robot.shooter.set(Robot.leftStick.getThrottle());
		} else {
			Robot.shooter.stop();
		}

		return 0;
	}
}