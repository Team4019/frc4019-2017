package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

enum DriveMode {ARCADE, TANK, TWIST, TRIPLE, HYBRID, DS4_ARCADE, DS4_TANK}

public abstract class Drive {
	static DriveMode driveMode = DriveMode.DS4_TANK;

	static void arcadeDrive() {
		double forward = Robot.rightStick.getY() * getDBSlider(0);
		double rotation = Robot.rightStick.getX() * getDBSlider(1);

		double left = forward + rotation;
		double right = forward - rotation;

		setMotors(left, right);
	}

	static void tankDrive() {
		double left = Robot.leftStick.getY() * getDBSlider(0);
		double right = Robot.leftStick.getX() * getDBSlider(0);

		setMotors(left, right);
	}

	static void hybridDrive() {

	}

	static void twistDrive() {

	}

	static void tripleDrive() {

	}

	static void ds4ArcadeDrive() {
		double forward = -Robot.rightStick.joystick.getY() * getDBSlider(0);
		double rotation = Robot.rightStick.joystick.getX() * getDBSlider(1);

		double left = forward + rotation;
		double right = forward - rotation;

		setMotors(left, right);
	}

	static void ds4TankDrive() {
		double throttle = (1 - getDBSlider(2)) / 2;
		double leftThrottle = (-Robot.rightStick.joystick.getRawAxis(3) * throttle) + (1 - throttle);
		double rightThrottle = (-Robot.rightStick.joystick.getRawAxis(4) * throttle) + (1 - throttle);
		double left = -Robot.rightStick.joystick.getRawAxis(1) * leftThrottle;
		double right = -Robot.rightStick.joystick.getRawAxis(5) * rightThrottle;
		setMotors(left * getDBSlider(0), right * getDBSlider(0));
	}

	static double getDBSlider(int id) {
		return SmartDashboard.getNumber("DB/Slider " + id) / 5;
	}

	static void setMotors(double left, double right) {
		Robot.leftDrive.set(left);
		Robot.rightDrive.set(right);
	}
}
