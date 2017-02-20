package org.usfirst.frc.team4019;

public abstract class Constants {
	// Peripherals attached to the computer
	static abstract class inputs {
		static final int leftStick = 0;
		static final int rightStick = 1;
		static final int climbUpButton = 7;
		static final int climbDownButton = 8;
		static final int scavangeButton = 2;
	}

	// Components attached to the robot
	static abstract class ports {
		static final int[] leftDrive = {0,1};
		static final int[] rightDrive = {2, 3};
		static final int scavenger = 1;
		static final int leftClimb = 3;
		static final int rightClimb = 9;
		static final int leftUltrasonic = 0;
		static final int rightUltrasonic = 1;
	}

	// Settings for the Climbing mechanism
	static abstract class climb {
		static final double speed = 0.4;
	}

	// Settings for the Scavenging mechanism
	static abstract class scavenger {
		static final double speed = 0.6;
	}

	// Settings for the Ultrasonic mechanism
	static abstract class ultrasonic {
		static final double spread = 1.0;
	}
}