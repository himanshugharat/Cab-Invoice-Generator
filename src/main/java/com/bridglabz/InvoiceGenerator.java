package com.bridglabz;

public class InvoiceGenerator {
    private static final double COST_PER_KM = 10;
    private static final int TIME_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;
    public double distance;
    public int time;

    public double calculateFare(double distance, int time) {
        this.distance = distance;
        this.time = time;
        double totalFare = distance * COST_PER_KM + time * TIME_PER_MIN;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
