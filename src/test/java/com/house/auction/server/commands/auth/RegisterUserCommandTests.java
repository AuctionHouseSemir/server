package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterUserCommandTests {

    @Test
    public void execute_UserDoesNotExist_ReturnsSuccess() {
        UserService userService = new UserServiceMock();

        RegisterUserCommand command = new RegisterUserCommand(userService);
        command.setUsername("user_abc");
        command.setPassword("password123");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Ok, responseDto.getStatus());
        Assert.assertEquals("welcome user_abc", responseDto.getContent());
    }

    @Test
    public void execute_UserAlreadyExists_ReturnsError() {
        UserService userService = new UserServiceMock();
        RegisterUserCommand command = new RegisterUserCommand(userService);
        command.setUsername("user_a");
        command.setPassword("password123");

        ResponseDto responseDto = command.execute();

        Assert.assertEquals(ResponseStatus.Error, responseDto.getStatus());
        Assert.assertEquals("user user_a already exists", responseDto.getContent());
    }
}
