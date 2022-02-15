package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.UserService;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterUserCommandTests {
    private RegisterUserCommand command;

    @Before
    public void setup() {
        UserService userService = new UserServiceMock();
        command = new RegisterUserCommand(userService);
    }

    @Test
    public void execute_UserDoesNotExist_ReturnsSuccess() {
        command.setUsername("user_abc");
        command.setPassword("password123");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Ok, responseDto.getStatus());
        Assert.assertEquals("welcome user_abc", responseDto.getContent());
    }

    @Test
    public void execute_UserAlreadyExists_ReturnsError() {
        command.setUsername("user_a");
        command.setPassword("password123");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Error, responseDto.getStatus());
        Assert.assertEquals("user user_a already exists", responseDto.getContent());
    }
}
