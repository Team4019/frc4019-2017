package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import java.util.ArrayList;

public class Drive {
	static class TalonGroup {
		ArrayList<CANTalon> talons;
		double throttle;

		TalonGroup(double throttle, int... args) {
			this.throttle = throttle;
			this.talons = new ArrayList<>();
			for (int arg : args) {
				talons.add(new CANTalon(arg));
			}
		}

		public void set(double value) {
			for (CANTalon talon : this.talons) {
				talon.set(value * this.throttle);
			}
		}

		public void setInverted(boolean value) {
			for (CANTalon talon : this.talons) {
				talon.setInverted(value);
			}
		}
	}
	TalonGroup leftDrive;
	TalonGroup rightDrive;

	public Drive(int[] leftDriveID, int[] rightDriveID) {
		this.leftDrive = new TalonGroup(Constants.drive.leftThrottle * Constants.drive.throttle, leftDriveID);
		this.rightDrive = new TalonGroup(Constants.drive.rightThrottle * Constants.drive.throttle, rightDriveID);
		this.leftDrive.setInverted(Constants.drive.invertLeft);
		this.rightDrive.setInverted(Constants.drive.invertRight);
	}

	public void arcadeDrive(double forward, double rotation, double throttle) {
		this.leftDrive.set((forward + rotation) * throttle);
		this.rightDrive.set((forward - rotation) * throttle);
	}

	public void arcadeDrive(double forward, double rotation) {
		this.arcadeDrive(forward, rotation, 1);
	}

	public void tankDrive(double left, double right, double throttle) {
		this.leftDrive.set(left * throttle);
		this.rightDrive.set(right * throttle);
	}

	public void tankDrive(double left, double right) {
		this.tankDrive(left, right, 1);
	}
}
