package com.house.auction.server.auth;

public class AuthToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        String[] tokenParsed = token.split("-");

        return Integer.parseInt(tokenParsed[0]);
    }

    public String getUsername() {
        return "user_1";
    }

    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        return token;
    }
}
