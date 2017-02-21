package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import java.util.ArrayList;

class TalonGroup {
	ArrayList<Talon> talons;

	TalonGroup(int... args) {
		this.talons = new ArrayList<>();
		for (int arg : args) {
			talons.add(new Talon(arg));
		}
	}

	public void set(double value) {
		for (Talon talon : this.talons) {
			talon.set(value);
		}
	}

	public void setInverted(boolean value) {
		for (Talon talon : this.talons) {
			talon.setInverted(value);
		}
	}
}

class Drivetrain {
	TalonGroup left;
	TalonGroup right;

	Drivetrain(TalonGroup left, TalonGroup right) {
		this.left = left;
		this.right = right;
		right.setInverted(true);
	}

	public void set(double... values) {
		values = Scale.compress(values);
		this.left.set(values[0]);
		this.right.set(values[1]);
	}
}

class ControlStick {
	Joystick joystick;

	ControlStick(int port) {
		this.joystick = new Joystick(port);
	}

	public double getX() {
		return this.joystick.getX();
	}

	public double getY() {
		return -this.joystick.getY();
	}

	public double getTwist() {
		double twist = this.joystick.getTwist();
		double center = -0.16;
		double deadzone = 0.2;
		return twist >= center ? Range.spread(twist, center + deadzone, 1) : Range.spread(twist, -1, center - deadzone) - 1;
	}

	public double getThrottle() {
		return this.joystick.getThrottle() * -0.5 + 0.5;
	}

	public double getRawAxis(int axis) {
		return this.joystick.getRawAxis(axis);
	}

	public int getPOV() {
		return this.joystick.getPOV();
	}

	public boolean getTrigger() {
		return this.joystick.getTrigger();
	}

	public boolean getRawButton(int button) {
		return this.joystick.getRawButton(button);
	}

	public int rawButton() {
		for (int button = 1; button <= 12; button++) {
			if (this.joystick.getRawButton(button)) return button;
		}
		return 0;
	}
}

public class Robot extends IterativeRobot {
	static ControlStick leftStick = new ControlStick(Constants.inputs.leftStick);
	static ControlStick rightStick = new ControlStick(Constants.inputs.rightStick);
	static Drivetrain drivetrain = new Drivetrain(new TalonGroup(Constants.ports.leftDrive), new TalonGroup(Constants.ports.rightDrive));
	static Ultrasonic ultrasonic = new Ultrasonic(0);
	static CvSink video;
	static CvSource stream;

	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture().setResolution(Constants.camera.size[0], Constants.camera.size[1]);
		video = CameraServer.getInstance().getVideo(Constants.ports.camera);
		stream = CameraServer.getInstance().putVideo("Robot Vision", Constants.camera.size[0], Constants.camera.size[1]);
		Main.init();
	}

	@Override
	public void robotPeriodic() {
		Main.periodic();
	}

	@Override
	public void disabledInit() {
		Main.disable();
	}

	@Override
	public void disabledPeriodic() {
		Main.idle();
		Timer.delay(0.001);
	}

	@Override
	public void autonomousInit() {
		Dashboard.clear();
		Autonomous.init();
	}

	@Override
	public void teleopInit() {
		Dashboard.clear();
		Teleoperated.init();
	}

	@Override
	public void testInit() {
		Dashboard.clear();
		Test.init();
	}

	@Override
	public void autonomousPeriodic() {
		Autonomous.periodic();
		Timer.delay(0.001);
	}

	@Override
	public void teleopPeriodic() {
		Teleoperated.periodic();
		Timer.delay(0.001);
	}

	@Override
	public void testPeriodic() {
		Test.periodic();
		Timer.delay(0.001);
	}
}