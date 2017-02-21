package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.*;

public class Robot extends IterativeRobot {
	static Joystick leftStick = new Joystick(Constants.sticks.leftStick);
	static Joystick rightStick = new Joystick(Constants.sticks.rightStick);
	static Drive drive = new Drive(Constants.drive.leftDriveID, Constants.drive.rightDriveID);
	static Scavenger scavenger = new Scavenger(Constants.scavenger.scavengerID);
	static Conveyor conveyor = new Conveyor(Constants.conveyor.conveyorID);
	static Shooter shooter = new Shooter(Constants.shooter.leftWheelID, Constants.shooter.rightWheelID);
	static Climb climb = new Climb(Constants.climb.leftClimbID, Constants.climb.rightClimbID);
	//static Ultrasonic ultrasonic = new Ultrasonic(Constants.ultrasonic.leftUltrasonicPort, Constants.ultrasonic.rightUltrasonicPort);

	@Override
	public void robotInit() {

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