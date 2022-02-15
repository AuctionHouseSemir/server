package com.house.auction.server;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.auth.AuthTokenGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTokenGeneratorTests {

    @Test
    public void generateToken_NonceProvided_ReturnsUserIdWithNonceProvided() {
        AuthTokenGenerator tokenGenerator = new AuthTokenGenerator();

        String token = tokenGenerator.generateToken(1, "abc");

        Assert.assertEquals("1;abc", token);
    }

    @Test
    public void generateToken_NonceNull_ReturnsUserIdWithUuid() {
        AuthTokenGenerator tokenGenerator = new AuthTokenGenerator();

        String token = tokenGenerator.generateToken(1, null);

        String[] tokenParsed = token.split(AuthToken.SEPARATOR);
        Assert.assertEquals(2, tokenParsed.length);

        int userId = Integer.parseInt(tokenParsed[0]);
        String uuid = tokenParsed[1];

        Assert.assertEquals(1, userId);
        Assert.assertNotNull(uuid);
    }

    @Test
    public void generateToken_NonceEmptyString_ReturnsUserIdWithUuid() {
        AuthTokenGenerator tokenGenerator = new AuthTokenGenerator();

        String token = tokenGenerator.generateToken(1, "");

        String[] tokenParsed = token.split(AuthToken.SEPARATOR);
        Assert.assertEquals(2, tokenParsed.length);

        int userId = Integer.parseInt(tokenParsed[0]);
        String uuid = tokenParsed[1];

        Assert.assertEquals(1, userId);
        Assert.assertNotNull(uuid);
    }
}
