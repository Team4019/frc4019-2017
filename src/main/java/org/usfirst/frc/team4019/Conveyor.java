package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Conveyor {
	enum ConveyorMode {FORWARD, REVERSE, DISABLED}

	CANTalon motor;
	ConveyorMode conveyorMode;

	public Conveyor(int talonID) {
		this.motor = new CANTalon(talonID);
		this.motor.setInverted(Constants.conveyor.inverted);
		this.conveyorMode = ConveyorMode.DISABLED;
	}

	public void start() {
		this.motor.set(Constants.conveyor.speed);
		this.conveyorMode = ConveyorMode.FORWARD;
		this.setDashboard();
	}

	public void reverse() {
		this.motor.set(-Constants.conveyor.speed);
		this.conveyorMode = ConveyorMode.REVERSE;
		this.setDashboard();
	}

	public void stop() {
		if (this.conveyorMode != ConveyorMode.DISABLED) {
			this.motor.set(0);
			this.conveyorMode = ConveyorMode.DISABLED;
			this.setDashboard();
		}
	}

	public void setDashboard() {
		Dashboard.write(Constants.conveyor.dashboard, "Conveyor: " + this.conveyorMode + ";");
	}
}