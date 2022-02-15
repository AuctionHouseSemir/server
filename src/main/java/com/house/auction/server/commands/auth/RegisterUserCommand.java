package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.UserAccount;
import com.house.auction.server.auth.UserService;
import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

public class RegisterUserCommand implements Command {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    private final UserService userService;

    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseDto execute() {
        UserAccount existingUser = userService.getUserByUsername(username);
        if (existingUser != null) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(ResponseStatus.Error);
            responseDto.setContent(String.format("user %s already exists", this.username));

            return responseDto;
        }

        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        
        userService.saveUser(user);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("welcome %s", this.username));

        return responseDto;
    }
}