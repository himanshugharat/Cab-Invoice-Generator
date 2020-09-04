package com.bridglabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class CabInvoiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    RideRepository rideRepository;

    InvoiceService invoiceService = null;

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(new Ride(distance, time), RideType.Normal);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(new Ride(distance, time), RideType.Normal);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenNormal_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides, RideType.Normal);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String userId = "himanshu";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRiders(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, RideType.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
        double distance = 1.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(new Ride(distance, time), RideType.Premium);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(new Ride(distance, time), RideType.Premium);
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenPremium_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides, RideType.Premium);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String userId = "himanshu";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRiders(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, RideType.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

}
