package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Conveyor {
	enum ConveyorMode {INTAKE, OUTTAKE, STOPPED}

	CANTalon motor;
	ConveyorMode conveyorMode;

	public Conveyor(int talonID) {
		this.motor = new CANTalon(talonID);
		this.motor.setInverted(Constants.conveyor.invertConveyor);
		this.conveyorMode = ConveyorMode.STOPPED;
	}

	public void start() {
		this.motor.set(Constants.conveyor.speed);
		this.conveyorMode = ConveyorMode.INTAKE;
		this.setDashboard();
	}

	public void reverse() {
		this.motor.set(-Constants.conveyor.speed);
		this.conveyorMode = ConveyorMode.OUTTAKE;
		this.setDashboard();
	}

	public void stop() {
		if (this.conveyorMode != ConveyorMode.STOPPED) {
			this.motor.set(0);
			this.conveyorMode = ConveyorMode.STOPPED;
			this.setDashboard();
		}
	}

	public void setDashboard() {
		SmartDashboard.putString(Constants.conveyor.dashboard, "CONVEYOR: " + this.conveyorMode + ";");
	}
}
