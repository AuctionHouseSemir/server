package com.house.auction.server.auth;

public class AuthToken {
    public static final String SEPARATOR = ";";
    private final String token;

    public AuthToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        String[] tokenParsed = token.split(SEPARATOR);
        int userId = 0;

        if (tokenParsed.length != 2) return userId;

        return tryParseUserId(tokenParsed[0]);
    }

    @Override
    public String toString() {
        return token;
    }

    private int tryParseUserId(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
