package com.bridglabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideStorage {
    Map<String, ArrayList<Ride>> userRides = new HashMap<>();

    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userId);
        this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRiders(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
