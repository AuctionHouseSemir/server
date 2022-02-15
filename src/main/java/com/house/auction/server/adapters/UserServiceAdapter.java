package com.house.auction.server.adapters;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapter implements UserService {
    @Override
    public void saveUser(UserAccount user) {

    }

    @Override
    public UserAccount getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean validCredentials(String username, String password) {
        return true;
    }
}
