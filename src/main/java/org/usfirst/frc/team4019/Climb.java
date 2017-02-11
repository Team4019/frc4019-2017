package org.usfirst.frc.team4019;
// Requires:
// Constants.java:      Constant defined for each button
// Robot.java:          Map work methods to motors
// Teleoperated.java:   Listeners mapped to buttons
public abstract class Climb {
    public static void ascend() {
        Robot.leftClimb.set(Constants.climb.speed);
        Robot.rightClimb.set(Constants.climb.speed);
    }

    public static void descend() {
        Robot.leftClimb.set(-Constants.climb.speed);
        Robot.rightClimb.set(-Constants.climb.speed);
    }

    public static void stop() {
        Robot.leftClimb.set(0);
        Robot.rightClimb.set(0);
    }
}