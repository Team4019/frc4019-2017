package org.usfirst.frc.team4019;

public abstract class Range {
    public static double clamp(double value, double endpoint1, double endpoint2) {
        // Find the minimum and maximum of the endpoints
        double min = Math.min(endpoint1, endpoint2);
        double max = Math.max(endpoint1, endpoint2);
        // If the number exceeds one of the endpoints, return that endpoint
        return Math.min(Math.max(value, min), max);
    }

    public static double clamp(double value) {
    	// Clamp the number between 0 and 1
        return clamp(value, 0, 1);
    }

    public static double squeeze(double value, double min, double max) {
    	// Return a number between 0 and 1 indicating a number's position between two endpoints
        return (clamp(value, min, max) - min) / (max - min);
    }

    public static double spread(double value, double min, double max) {
    	// Return the position of a number from 0 to 1 relative to two endpoints (inverse of squeeze)
        return clamp(value) * (max - min) + min;
    }
}