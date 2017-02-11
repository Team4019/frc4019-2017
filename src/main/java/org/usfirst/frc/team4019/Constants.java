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
		static final int[] leftDrive = {6, 7};
		static final int[] rightDrive = {8, 9};
		static final String camera = "cam0";
		static final int leftClimb = 0;// TODO Find actual port number
		static final int rightClimb = 2;// TODO Find actual port numbers
	}


	static abstract class climb {
		static final double speed = 0.4;
	}
}