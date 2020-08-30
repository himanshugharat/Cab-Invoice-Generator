package com.bridglabz;

public class InvoiceGenerator {
    public RideStorage rideStorage = new RideStorage();

    public double calculateFare(Ride ride, RideType type) {
        return type.calculateFare(ride);
    }

    public InvoiceSummary calculateFare(Ride[] rides, RideType type) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride, type);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }


    public void addRiders(String userId, Ride[] rides) {

        rideStorage.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId, RideType type) {
        return this.calculateFare(rideStorage.getRiders(userId), type);
    }
}
