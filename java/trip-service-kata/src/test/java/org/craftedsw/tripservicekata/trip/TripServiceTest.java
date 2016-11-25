package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collections;
import java.util.List;

import static org.craftedsw.tripservicekata.trip.TripTestData.someTrips;
import static org.craftedsw.tripservicekata.user.UserTestData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {
    
    @Mock
    private UserSession userSessionMock;

    @Mock
    private TripDAO tripDAOMock;
    
    private TripService sut;

    @Before
    public void setUp() {
        sut = new TripService(userSessionMock, tripDAOMock);
    }

    @Test(expected = UserNotLoggedInException.class)
    public void shouldThrowUserNotLoggedInExceptionIfLoggedUserIsNull() {
        whenLoggedUserIs(null);
        
        sut.getTripsByUser(null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEWhenUserIsNull() {
        whenLoggedUserIs(someUser());

        sut.getTripsByUser(null);
    }

    @Test
    public void shouldReturnNoTripsForUserWithoutFriends() {
        // setup
        whenLoggedUserIs(someUser());

        // exercise
        List<Trip> trips = sut.getTripsByUser(userWithoutFriends());

        // verify
        assertThat(trips, is(Collections.<Trip>emptyList()));
    }

    @Test
    public void shouldReturnUsersTripsIfFriedOfLoggedUser() {
        // setup
        User loggedUser = someUser();
        User user = friendOf(loggedUser);

        List<Trip> expectedTrips = someTrips();
        whenLoggedUserIs(loggedUser);
        whenGettingTripsFor(user).thenReturn(expectedTrips);

        // exercise
        List<Trip> actualTrips = sut.getTripsByUser(user);

        // verify
        assertThat(actualTrips, is(expectedTrips));
    }

    private OngoingStubbing<List<Trip>> whenGettingTripsFor(User user) {
        return when(tripDAOMock.findTripsByUser(user));
    }

    private void whenLoggedUserIs(User loggedUser) {
        when(userSessionMock.getLoggedUser()).thenReturn(loggedUser);
    }

}
