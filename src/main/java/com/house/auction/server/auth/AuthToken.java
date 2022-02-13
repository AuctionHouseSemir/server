package com.house.auction.server.auth;

public class AuthToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return 1;
    }

    public String getUsername() {
        return "user_1";
    }

    @Override
    public String toString() {
        return token;
    }
}
