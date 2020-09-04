package com.bridglabz;

public class InvoiceService {
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

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
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId, RideType type) {
        return this.calculateFare(rideRepository.getRiders(userId), type);
    }
}
