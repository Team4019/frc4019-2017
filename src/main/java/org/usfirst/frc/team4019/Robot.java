package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.*;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

public class Robot extends IterativeRobot {
	static Joystick leftStick = new Joystick(Constants.sticks.leftID);
	static Joystick rightStick = new Joystick(Constants.sticks.rightID);
	static Drivetrain drivetrain = new Drivetrain(Constants.drive.leftID, Constants.drive.rightID);
	static Intake intake = new Intake(Constants.intake.ID);
	static Conveyor conveyor = new Conveyor(Constants.conveyor.ID);
	static Shooter shooter = new Shooter(Constants.shooter.leftID, Constants.shooter.rightID);
	static Climb climb = new Climb(Constants.climb.leftClimbID, Constants.climb.rightClimbID);
	//static Ultrasonic ultrasonic = new Ultrasonic(Constants.ultrasonic.leftID, Constants.ultrasonic.rightID);
	static Relay lights = new Relay(0);
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
	public void autonomousPeriodic() {
		Autonomous.periodic();
		Timer.delay(0.001);
	}

	@Override
	public void teleopInit() {
		Teleoperated.init();
	}

	@Override
	public void teleopPeriodic() {
		Teleoperated.periodic();
		Timer.delay(0.001);
	}

	@Override
	public void testInit() {
		Test.init();
	}

	@Override
	public void testPeriodic() {
		Test.periodic();
		Timer.delay(0.001);
	}
}