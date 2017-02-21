package org.usfirst.frc.team4019;

public abstract class Main {
	public static int init() {
		Dashboard.clear();
		Vision.start();
		return 0;
	}

	public static int periodic() {
		return 0;
	}

	public static int disable() {
		Vision.interrupt();
		return 0;
	}

	public static int idle() {
		return 0;
	}
}