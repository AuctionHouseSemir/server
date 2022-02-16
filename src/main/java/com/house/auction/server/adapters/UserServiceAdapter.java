package com.house.auction.server.adapters;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceAdapter implements UserService {
    private final CopyOnWriteArrayList<UserAccount> userAccounts;
    private final AtomicInteger usersCounter;

    public UserServiceAdapter() {
        this.userAccounts = new CopyOnWriteArrayList<>();
        this.usersCounter = new AtomicInteger();
    }

    @Override
    public void saveUser(UserAccount user) {
        user.setId(usersCounter.incrementAndGet());
        userAccounts.add(user);
    }

    @Override
    public UserAccount getUserByUsername(String username) {
        return userAccounts.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean validCredentials(String username, String password) {
        return true;
    }
}
