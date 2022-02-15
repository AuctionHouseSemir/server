package com.house.auction.server.auth;

import java.util.UUID;

public class AuthTokenGenerator {

    public String generateToken(int userId) {
        UUID uuid = UUID.randomUUID();
        return String.format("%d-%s", userId, uuid);
    }
}
