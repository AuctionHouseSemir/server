package com.house.auction.server.auth;

import java.util.UUID;

public class AuthTokenGenerator {

    public String generateToken(int userId, String nonce) {
        if (nonce == null || nonce.length() == 0) nonce = UUID.randomUUID().toString();

        return String.format("%d%s%s", userId, AuthToken.SEPARATOR, nonce);
    }
}
