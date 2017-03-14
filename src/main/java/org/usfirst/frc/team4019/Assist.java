package org.usfirst.frc.team4019;

public class Assist {
	public static void assist(boolean distance, boolean angle) {
		if (Vision.boilerAngle != null && Math.abs(Vision.boilerAngle) > 2.5) {
			Robot.drive.drive(0, angle ? Math.cbrt(-Vision.boilerAngle) : 0);
		}
	}
}