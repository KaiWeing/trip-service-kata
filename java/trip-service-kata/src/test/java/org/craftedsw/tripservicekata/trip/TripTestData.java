package org.craftedsw.tripservicekata.trip;

import java.util.Collections;
import java.util.List;

public class TripTestData {

    private TripTestData() {

    }

    public static Trip someTrip() {
        return new Trip();
    }

    public static List<Trip> someTrips() {
        return Collections.singletonList(someTrip());
    }
}
