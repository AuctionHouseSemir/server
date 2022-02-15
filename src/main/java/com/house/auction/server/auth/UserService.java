package com.house.auction.server.auth;

public interface UserService {
    void saveUser(UserAccount user);
    UserAccount getUserByUsername(String username);
    boolean validCredentials(String username, String password);
}
