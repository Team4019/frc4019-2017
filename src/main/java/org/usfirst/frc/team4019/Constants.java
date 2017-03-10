package org.usfirst.frc.team4019;

public abstract class Constants {
	// Peripherals attached to the computer
	static abstract class sticks {
		static final int leftStick = 0;
		static final int rightStick = 1;
	}

	// Settings related to the Drive system
	static abstract class drive {
		static final int[] leftDriveID = {10, 11, 12};
		static final int[] rightDriveID = {4, 5, 6};
		static final boolean invertLeft = true;
		static final boolean invertRight = false;
		static final double leftThrottle = 1;
		static final double rightThrottle = 1;
		static final double throttle = 1;
		static final String dashboard = "DB/String 0";
	}

	// Settings related to the scavenging mechanism
	static abstract class scavenger {
		static final int scavengerID = 8;
		static final boolean invertScavenger = true;
		static final int intakeButton = 5;
		static final int outtakeButton = 3;
		static final double speed = 1.0;
		static final String dashboard = "DB/String 1";
	}

	// Settings related to the Conveyor mechanism
	static abstract class conveyor {
		static final int conveyorID = 2;
		static final boolean invertConveyor = true;
		static final int invertButton = 4;
		static final double speed = .6;
		static final String dashboard = "DB/String 2";
	}

	// Settings related to the Shooting mechanism
	static abstract class shooter {
		static final int leftWheelID = 1;
		static final int rightWheelID = 7;
		static final boolean invertLeftWheel = true;
		static final boolean invertRightWheel = false;
		static final int safetyButton = 1;
		static final int throttleAxis = 6;
		static final double speed = 1.0;
		static final double angle = 60; // degrees
		static final String dashboard = "DB/String 3";
	}

	// Settings related to the Climbing mechanism
	static abstract class climb {
		static final int leftClimbID = 3;
		static final int rightClimbID = 9;
		static final boolean invertLeftClimb = true;
		static final boolean invertRightClimb = false;
		static final int safetyButton = 2;
		static final double speed = 0.4;
		static final String dashboard = "DB/String 4";
	}

	// Settings related to the Ultrasonic mechanism
	static abstract class ultrasonic {
		static final int leftUltrasonicPort = 8;
		static final int rightUltrasonicPort = 9;
		static final double spread = 1.0;
	}

	static abstract class alignment {
		static final int rotationButton = 1;
		static final int movementButton = 2;
	}

	// Information relating to the camera (excluding its port)
	static abstract class camera {
		static final String cameraID = "USB Camera 0";
		static final int[] size = {640, 480};
		static final double fov = 50; // degrees
	}

	// Information relating to the game field
	static abstract class field {
		static final double boilerWidth = 15; // inches
	}
}
