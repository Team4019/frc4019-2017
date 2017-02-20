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
		static final String camera = "cam0";
		static final int scavenger = -1; // TODO Find actual port numbers
	}

	static abstract class scavenger {
		static final double speed = 0.6;
	}
}