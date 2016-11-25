package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.junit.Test;

public class TripDAOTest {

    @Test(expected = CollaboratorCallException.class)
    public void findTripsByUserShouldAlwaysThrowException() {
        TripDAO sut = TripDAO.getInstance();

        sut.findTripsByUser(null);
    }
}
