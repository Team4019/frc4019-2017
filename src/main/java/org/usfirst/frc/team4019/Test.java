package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Test {
	public static int init() {
		return 0;
	}

	public static int periodic() {
		if (Robot.leftStick.getRawButton(0)) {
			Robot.spark1.set(Robot.leftStick.getThrottle());
		} else {
			Robot.spark1.set(0);
		}

		if (Robot.rightStick.getRawButton(0)) {
			Robot.spark2.set(Robot.rightStick.getThrottle());
		} else {
			Robot.spark2.set(0);
		}

		return 0;
	}
}