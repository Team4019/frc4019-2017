package org.usfirst.frc.team4019;

public abstract class Constants {
	// Peripherals attached to the computer
	static abstract class inputs {
		static final int leftStick =
				0;
		static final int rightStick =1;
	}

	// Components attached to the robot
	static abstract class ports {
		static final int[] leftDrive= {0,1};
		static final int[] rightDrive = {2, 3};
		static final String camera = "cam0";
		static final int portUltrasonic = 0;
		static final int starboardUltrasonic =1;
	}

	static abstract class ultrasonic {
		static final double spread =1.0;
	}
}