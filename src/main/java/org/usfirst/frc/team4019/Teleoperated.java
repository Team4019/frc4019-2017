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
		DriveMode previous = Drive.driveMode;
		switch (Robot.rightStick.joystick.getPOV()) {
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
		}
		if (Drive.driveMode != previous) {
			System.out.println("Drive mode changed to: " + Drive.driveMode);
		}

		switch (Drive.driveMode) {
			case ARCADE:
				break;
			case HYBRID:
				break;
			case TANK:
				break;
			case DS4_ARCADE:
				Drive.ds4ArcadeDrive();
				break;
			case DS4_TANK:
				Drive.ds4TankDrive();
				break;
		}
		Robot.ultrasonic.update();
		SmartDashboard.putString("DB/String 0", Double.toString(Robot.ultrasonic.getDistance()));
		return 0;
	}
}