package org.usfirst.frc.team4019;

import com.ctre.CANTalon;

public class Intake {
	enum IntakeMode {FORWARD, REVERSE, DISABLED}

    CANTalon motor;
    IntakeMode mode;

    public Intake(int ID) {
        this.motor = new CANTalon(ID);
        this.motor.setInverted(Constants.intake.inverted);
        this.mode = IntakeMode.DISABLED;
    }

    public void start() {
        this.motor.set(Constants.intake.speed);
        this.mode = IntakeMode.FORWARD;
        this.setDashboard();
    }

    public void reverse() {
        this.motor.set(-Constants.intake.speed);
	    this.mode = IntakeMode.REVERSE;
	    this.setDashboard();
    }

    public void stop() {
        if (this.mode != IntakeMode.DISABLED) {
            this.motor.set(0);
	        this.mode = IntakeMode.DISABLED;
	        this.setDashboard();
        }
    }

    public void setDashboard() {
	    Dashboard.write(Constants.intake.dashboard, "Intake: " + this.mode);
    }
}