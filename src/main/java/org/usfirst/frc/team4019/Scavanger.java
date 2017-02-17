package org.usfirst.frc.team4019;

public class Scavanger {
    static boolean scavanging = false;

    public static void scavange() {
        Robot.leftScavange.set(Constants.scavanger.speed);
        Robot.rightScavange.set(Constants.scavanger.speed);
        scavanging = true;
    }




    public static void stop() {
        if (scavanging) {
            Robot.leftScavange.set(0);
            Robot.rightScavange.set(0);
            scavanging = false;
        }
    }
}
