package com.house.auction.server;

import com.house.auction.server.auth.AuthToken;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTokenTests {

    @Test
    public void getUserId_ValidTokenString_ReturnsUserId() {
        AuthToken authToken = new AuthToken("1;random-string-123");

        int userId = authToken.getUserId();

        Assert.assertEquals(1, userId);
    }

    @Test
    public void getUserId_InvalidUserIdType_ReturnsZero() {
        AuthToken authToken = new AuthToken("a;random-string-123");

        int userId = authToken.getUserId();

        Assert.assertEquals(0, userId);
    }

    @Test
    public void getUserId_MissingUserId_ReturnsZero() {
        AuthToken authToken = new AuthToken(";random-string-123");

        int userId = authToken.getUserId();

        Assert.assertEquals(0, userId);
    }

    @Test
    public void getUserId_RightSideOfSeparatorMissing_ReturnsZero() {
        AuthToken authToken = new AuthToken("1;");

        int userId = authToken.getUserId();

        Assert.assertEquals(0, userId);
    }

    @Test
    public void getUserId_TokenSeparatorMissing_ReturnsZero() {
        AuthToken authToken = new AuthToken("random-string-123");

        int userId = authToken.getUserId();

        Assert.assertEquals(0, userId);
    }

    @Test
    public void getUserId_OnlySeparatorProvided_ReturnsZero() {
        AuthToken authToken = new AuthToken(";");

        int userId = authToken.getUserId();

        Assert.assertEquals(0, userId);
    }
}
