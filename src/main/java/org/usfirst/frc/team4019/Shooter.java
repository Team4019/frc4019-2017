package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
	enum ShootingMode {SHOOTING, STOPPED}

	CANTalon leftWheel;
	CANTalon rightWheel;
	ShootingMode shooting;

	public Shooter(int leftTalonID, int rightTalonID) {
		this.leftWheel = new CANTalon(leftTalonID);
		this.rightWheel = new CANTalon(rightTalonID);
		this.leftWheel.setInverted(Constants.shooter.invertLeftWheel);
		this.rightWheel.setInverted(Constants.shooter.invertRightWheel);
		this.shooting = ShootingMode.STOPPED;
		this.setDashboard(0);
	}

	public void set(double value) {
		this.leftWheel.set(value * Constants.shooter.speed);
		this.rightWheel.set(value * Constants.shooter.speed);
		this.shooting = ShootingMode.SHOOTING;
		this.setDashboard(value);
	}

	public void stop(double value) {
		if (this.shooting != ShootingMode.STOPPED) {
			this.leftWheel.set(0);
			this.rightWheel.set(0);
		}
		this.setDashboard(value);
	}

	public void setDashboard(double value) {
		//SmartDashboard.putString(Constants.shooter.dashboard, "SHOOTER: " + this.shooting + "; " + Math.round(value * 100) + "%");
	}
}
