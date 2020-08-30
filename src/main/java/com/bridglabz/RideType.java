package com.bridglabz;

public enum RideType {
    Premium(15.0, 2, 20),
    Normal(10.0, 1, 5);

    private final double costPrekilometer;
    private final int minimumCost;
    private final int costPerMinute;

    RideType(double costPrekilometer, int costPerMinute, int minimumCost) {
        this.costPrekilometer = costPrekilometer;
        this.costPerMinute = costPerMinute;
        this.minimumCost = minimumCost;
    }

    public double calculateFare(Ride ride) {
        double totalFare = ride.distance * costPrekilometer + ride.time * costPerMinute;
        return Math.max(totalFare, minimumCost);
    }
}
