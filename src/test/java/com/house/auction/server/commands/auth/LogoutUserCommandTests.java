package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.cache.CacheStorage;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogoutUserCommandTests {

    @Test
    public void execute_ReturnsSuccess() {
        CacheStorage cacheStorage = new CacheStorageMock();

        LogoutUserCommand command = new LogoutUserCommand(cacheStorage);
        AuthToken authToken = new AuthToken("1;random-string");
        command.setAuthToken(authToken);

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Ok, responseDto.getStatus());
        Assert.assertEquals("user logged out", responseDto.getContent());
    }
}
