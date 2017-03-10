package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

import java.util.ArrayList;

public class Drivetrain {
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

	public Drivetrain(int[] leftDriveID, int[] rightDriveID) {
		this.leftDrive = new TalonGroup(Constants.drive.leftThrottle * Constants.drive.throttle, leftDriveID);
		this.rightDrive = new TalonGroup(Constants.drive.rightThrottle * Constants.drive.throttle, rightDriveID);
		this.leftDrive.setInverted(Constants.drive.leftInverted);
		this.rightDrive.setInverted(Constants.drive.rightInverted);
	}

	public void drive(double forward, double rotation, double throttle) {
		this.leftDrive.set((forward + rotation) * throttle);
		this.rightDrive.set((forward - rotation) * throttle);
		Dashboard.write(Constants.drive.dashboard, "Drive: ARCADE @ " + Math.round(throttle * 100) + "%");
	}

	public void drive(double forward, double rotation) {
		this.drive(forward, rotation, 1);
	}
}