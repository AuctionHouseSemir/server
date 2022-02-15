package com.house.auction.server.infrastructure;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapter implements UserService {
    @Override
    public void saveUser(UserAccount user) {

    }

    @Override
    public UserAccount getUserById(int userId) {
        return null;
    }

    @Override
    public UserAccount getUserByUsername(String username) {
        return null;
    }
}
