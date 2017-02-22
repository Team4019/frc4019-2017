package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb {
	CANTalon leftMotor;
	CANTalon rightMotor;

	public Climb(int leftTalonID, int rightTalonID) {
		this.leftMotor = new CANTalon(leftTalonID);
		this.rightMotor = new CANTalon(rightTalonID);
		this.leftMotor.setInverted(Constants.climb.invertLeftClimb);
		this.rightMotor.setInverted(Constants.climb.invertRightClimb);
	}

	public void set(double value) {
		this.leftMotor.set(value * Constants.climb.speed);
		this.rightMotor.set(value * Constants.climb.speed);
	}

	public void stop() {
		this.leftMotor.set(0);
		this.rightMotor.set(0);
	}

	public void setDashboard(boolean left, boolean right, double axis) {
		SmartDashboard.putString(Constants.climb.dashboard, "CLIMB: " + left + ", " + right + "; " + Math.round(axis * 100) + "%");
	}
}
