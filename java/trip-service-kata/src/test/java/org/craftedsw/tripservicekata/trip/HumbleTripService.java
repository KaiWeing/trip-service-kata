package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.UserSession;

// Was used during testing
public class HumbleTripService extends TripService {

    private UserSession userSession;
    private TripDAO tripDAO;

    public HumbleTripService(UserSession userSession, TripDAO tripDAO) {
        this.userSession = userSession;
        this.tripDAO = tripDAO;
    }

    @Override
    protected UserSession getUserSession() {
        return userSession;
    }

    @Override
    protected TripDAO getTripDAO() {
        return tripDAO;
    }
}
