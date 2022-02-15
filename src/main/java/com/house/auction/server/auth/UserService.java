package com.house.auction.server.auth;

public interface UserService {
    void saveUser(UserAccount user);
    UserAccount getUserById(int userId);
    UserAccount getUserByUsername(String username);
}
