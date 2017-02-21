package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.*;
import java.util.ArrayList;

class TalonGroup {
	ArrayList<CANTalon> talons;

	TalonGroup(int... args) {
		this.talons = new ArrayList<>();
		for (int arg : args) {
			talons.add(new CANTalon(arg));
		}
	}

	public void set(double value) {
		for (CANTalon talon : this.talons) {
			talon.set(value);
		}
	}

	public void setInverted(boolean value) {
		for (CANTalon talon : this.talons) {
			talon.setInverted(value);
		}
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
	public boolean getTrigger() {
		return this.joystick.getTrigger();
	}
	public boolean getRawButton(int button) {
		return this.joystick.getRawButton(button);
	}
}

public class Robot extends IterativeRobot {
	static ControlStick leftStick = new ControlStick(Constants.sticks.leftStick);
	static ControlStick rightStick = new ControlStick(Constants.sticks.rightStick);
	static TalonGroup leftDrive = new TalonGroup(Constants.drive.leftDriveID);
	static TalonGroup rightDrive = new TalonGroup(Constants.drive.rightDriveID);
	static Scavenger scavenger = new Scavenger(Constants.scavenger.scavengerID);
	static Conveyor conveyor = new Conveyor(Constants.conveyor.conveyorID);
	static Shooter shooter = new Shooter(Constants.shooter.leftWheelID, Constants.shooter.rightWheelID);
	static Climb climb = new Climb(Constants.climb.leftClimbID, Constants.climb.rightClimbID);
	static Ultrasonic ultrasonic = new Ultrasonic(Constants.ultrasonic.leftUltrasonicPort, Constants.ultrasonic.rightUltrasonicPort);
	static Spark spark1 = new Spark(6);
	static Spark spark2 = new Spark(7);

	@Override
	public void robotInit() {
		rightDrive.setInverted(true);
	}

	@Override
	public void autonomousInit() {
		Autonomous.init();
	}

	@Override
	public void teleopInit() {
		Teleoperated.init();
	}

	@Override
	public void testInit() {
		Test.init();
	}

	@Override
	public void disabledInit() {
		Disabled.init();
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

	@Override
	public void disabledPeriodic() {
		Disabled.periodic();
		Timer.delay(0.001);
	}
}