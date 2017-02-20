package org.usfirst.frc.team4019;

public abstract class Constants {
	// Peripherals attached to the computer
	static abstract class inputs {
		static final int leftStick = 0;
		static final int rightStick = 1;
		static final int climbUpButton = 7;
		static final int climbDownButton = 8;
	}

	// Components attached to the robot
	static abstract class ports {
		static final int[] leftDrive = {0,1};
		static final int[] rightDrive = {2, 3};
		static final int leftClimb = 3;
		static final int rightClimb = 9;
	}

	// Settings for the Climbing mechanism
	static abstract class climb {
		static final double speed = 0.4;
	}
}