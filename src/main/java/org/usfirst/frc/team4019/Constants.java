package org.usfirst.frc.team4019;

public abstract class Constants {
	// Peripherals attached to the computer
	static abstract class inputs {
		static final int leftStick = 0;
		static final int rightStick = 1;
	}

	// Components attached to the robot
	static abstract class ports {
		static final int[] leftDrive = {0, 1};
		static final int[] rightDrive = {2, 3};
		static final String camera = "USB Camera 0";
	}

	// Information relating to the camera (excluding its port)
	static abstract class camera {
		static int[] size = {640, 480};
		static double fov = 50; // degrees
	}

	// Information relating to the game field
	static abstract class field {
		static double boilerWidth = 15; // inches
	}

	// Information relating to the ball shooter
	static abstract class shooter {
		static double angle = 60; // degrees
		static double coefficient;
	}

	// Physical constants used for calculations
	static abstract class physics {
		static double gravity;
	}
}