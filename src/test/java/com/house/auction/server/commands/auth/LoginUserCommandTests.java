package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.auth.UserService;
import com.house.auction.server.cache.CacheStorage;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginUserCommandTests {

    @Test
    public void execute_ValidCredentials_ReturnsAuthToken() {
        UserService userService = new UserServiceMock();
        CacheStorage cacheStorage = new CacheStorageMock();

        LoginUserCommand command = new LoginUserCommand(userService, cacheStorage);
        command.setUsername("user_a");
        command.setPassword("password123");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Ok, responseDto.getStatus());
        Assert.assertNotNull(responseDto.getContent());

        AuthToken authToken = new AuthToken(responseDto.getContent());
        Assert.assertTrue(authToken.getUserId() > 0);
    }

    @Test
    public void execute_InvalidCredentials_ReturnsError() {
        UserService userService = new UserServiceMock();
        CacheStorage cacheStorage = new CacheStorageMock();

        LoginUserCommand command = new LoginUserCommand(userService, cacheStorage);
        command.setUsername("user_a");
        command.setPassword("invalidPassword");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Error, responseDto.getStatus());
        Assert.assertEquals("invalid credentials", responseDto.getContent());
    }
}
