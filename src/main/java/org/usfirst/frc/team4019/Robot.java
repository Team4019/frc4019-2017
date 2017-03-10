package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.*;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

public class Robot extends IterativeRobot {
	static Joystick leftStick = new Joystick(Constants.sticks.leftStick);
	static Joystick rightStick = new Joystick(Constants.sticks.rightStick);
	static Drivetrain drivetrain = new Drivetrain(Constants.drive.leftDriveID, Constants.drive.rightDriveID);
	static Scavenger scavenger = new Scavenger(Constants.scavenger.scavengerID);
	static Conveyor conveyor = new Conveyor(Constants.conveyor.conveyorID);
	static Shooter shooter = new Shooter(Constants.shooter.leftWheelID, Constants.shooter.rightWheelID);
	static Climb climb = new Climb(Constants.climb.leftClimbID, Constants.climb.rightClimbID);
	//static Ultrasonic ultrasonic = new Ultrasonic(Constants.ultrasonic.leftUltrasonicPort, Constants.ultrasonic.rightUltrasonicPort);
	static Relay test = new Relay(0);
	static CvSink video;
	static CvSource stream;

	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture().setResolution(Constants.camera.size[0], Constants.camera.size[1]);
		video = CameraServer.getInstance().getVideo(Constants.camera.cameraID);
		stream = CameraServer.getInstance().putVideo("Robot Vision", Constants.camera.size[0], Constants.camera.size[1]);
		Main.init();
	}

	@Override
	public void robotPeriodic() {
		Main.periodic();
		Timer.delay(0.001);
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