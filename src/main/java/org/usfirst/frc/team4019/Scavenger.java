package org.usfirst.frc.team4019;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Scavenger {
	enum ScavengeMode {INTAKE, OUTTAKE, STOPPED}

    CANTalon motor;
    ScavengeMode scavenging;

    public Scavenger(int talonID) {
        this.motor = new CANTalon(talonID);
        this.motor.setInverted(Constants.scavenger.invertScavenger);
        this.scavenging = ScavengeMode.STOPPED;
    }

    public void start() {
        this.motor.set(Constants.scavenger.speed);
        this.scavenging = ScavengeMode.INTAKE;
        this.setDashboard();
    }

    public void reverse() {
        this.motor.set(-Constants.scavenger.speed);
	    this.scavenging = ScavengeMode.OUTTAKE;
	    this.setDashboard();
    }

    public void stop() {
        if (this.scavenging != ScavengeMode.STOPPED) {
            this.motor.set(0);
	        this.scavenging = ScavengeMode.STOPPED;
	        this.setDashboard();
        }
    }

    public void setDashboard() {
	    SmartDashboard.putString(Constants.scavenger.dashboard, "SCAVENGER: " + this.scavenging + ";");
    }
}
