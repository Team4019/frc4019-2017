package org.usfirst.frc.team4019;

public class Assist {
	public static boolean assist(boolean distance, boolean angle) {
		if (!distance && !angle) return false;
		if (Vision.boilerAngle != null && Math.abs(Vision.boilerAngle) > 2.5) {
			Robot.drive.set(0, angle ? Math.cbrt(-Vision.boilerAngle) : 0);
		}
		return true;
	}
}