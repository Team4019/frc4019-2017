package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Conveyor {
	enum ConveyorMode {FORWARD, REVERSE, DISABLED}

	CANTalon motor;
	ConveyorMode mode;

	public Conveyor(int ID) {
		this.motor = new CANTalon(ID);
		this.motor.setInverted(Constants.conveyor.inverted);
		this.mode = ConveyorMode.DISABLED;
	}

	public void forward() {
		this.motor.set(Constants.conveyor.speed);
		this.mode = ConveyorMode.FORWARD;
		this.setDashboard();
	}

	public void reverse() {
		this.motor.set(-Constants.conveyor.speed);
		this.mode = ConveyorMode.REVERSE;
		this.setDashboard();
	}

	public void stop() {
		if (this.mode != ConveyorMode.DISABLED) {
			this.motor.set(0);
			this.mode = ConveyorMode.DISABLED;
			this.setDashboard();
		}
	}

	public void setDashboard() {
		Dashboard.write(Constants.conveyor.dashboard, "Conveyor: " + this.mode);
	}
}