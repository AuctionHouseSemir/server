package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;

public class UserServiceMock implements UserService {
    @Override
    public void saveUser(UserAccount user) {

    }

    @Override
    public UserAccount getUserByUsername(String username) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1);
        userAccount.setUsername("user_a");
        userAccount.setPassword("password213");

        return username.equals("user_a") ? userAccount : null;
    }

    @Override
    public boolean validCredentials(String username, String password) {
        return password.equals("password123");
    }
}
