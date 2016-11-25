package org.craftedsw.tripservicekata.user;

public class UserTestData {

    private UserTestData() {

    }

    public static User friendOf(User friend) {
        User user = new User();
        user.addFriend(friend);
        return user;
    }

    public static User userWithoutFriends() {
        return new User();
    }

    public static User someUser() {
        return new User();
    }
}
