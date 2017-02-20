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
		static final int leftThrottle = 1;
		static final int rightThrottle = 1;
		static final int throttle = 1;
	}

	// Settings related to the scavenging mechanism
	static abstract class scavenger {
		static final int scavengerID = 1;
		static final int intakeButton = 5;
		static final int outtakeButton = 3;
		static final double speed = 0.6;
	}

	// Settings related to the Conveyor mechanism
	static abstract class conveyor {
		static final int conveyorID = 7;
		static final int intakeButton = 6;
		static final int outtakeButton = 4;
		static final double speed = .6;
	}

	// Settings related to the Shooting mechanism
	static abstract class shooter {
		static final int leftWheelID = 2;
		static final int rightWheelID = 8;
		static final int safetyButton = 1;
		static final int throttleAxis = 6;
		static final double speed = 1.0;
	}

	// Settings related to the Climbing mechanism
	static abstract class climb {
		static final int leftClimbID = 3;
		static final int rightClimbID = 9;
		static final int safetyButton = 2;
		static final double speed = 0.4;
	}

	// Settings related to the Ultrasonic mechanism
	static abstract class ultrasonic {
		static final int leftUltrasonicPort = 8;
		static final int rightUltrasonicPort = 9;
		static final double spread = 1.0;
	}
}
