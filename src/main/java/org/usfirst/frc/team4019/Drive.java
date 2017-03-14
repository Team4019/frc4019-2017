package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

import java.util.ArrayList;

public class Drive {
	static class CANTalonGroup {
		ArrayList<CANTalon> talons;
		double throttle;

		CANTalonGroup(double throttle, int... args) {
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

	enum DriveMode {ARCADE}

	CANTalonGroup leftDrive;
	CANTalonGroup rightDrive;
	DriveMode mode;

	public Drive(int[] leftID, int[] rightID) {
		this.leftDrive = new CANTalonGroup(Constants.drive.leftThrottle * Constants.drive.throttle, leftID);
		this.rightDrive = new CANTalonGroup(Constants.drive.rightThrottle * Constants.drive.throttle, rightID);
		this.leftDrive.setInverted(Constants.drive.leftInverted);
		this.rightDrive.setInverted(Constants.drive.rightInverted);
		this.mode = DriveMode.ARCADE;
	}

	public void drive(double forward, double rotation, double throttle) {
		this.leftDrive.set((forward + rotation) * throttle);
		this.rightDrive.set((forward - rotation) * throttle);
		Dashboard.write(Constants.drive.dashboard, "Drive: " + this.mode + " @ " + Math.round(throttle * 100) + "%");
	}

	public void drive(double forward, double rotation) {
		this.drive(forward, rotation, 1);
	}
}