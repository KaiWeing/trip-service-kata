package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripTestData;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void newUserShouldHaveNoFriends() {
        User user = new User();

        assertThat(user.getFriends(), is(Collections.<User>emptyList()));
    }

    @Test
    public void newUserShouldHaveNoTrips() {
        User user = new User();

        assertThat(user.trips(), is(Collections.<Trip>emptyList()));
    }

    @Test
    public void addFriendShouldAddFriend() {
        User user = new User();
        User friend = UserTestData.someUser();

        user.addFriend(friend);

        assertThat(user.getFriends(), is(Collections.singletonList(friend)));
    }

    @Test
    public void addTripShouldAddTrip() {
        User user = new User();
        Trip trip = TripTestData.someTrip();

        user.addTrip(trip);

        assertThat(user.trips(), is(Collections.singletonList(trip)));
    }

}
