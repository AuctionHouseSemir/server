package com.house.auction.server.commands.auth;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class LoginUserCommand implements Command {
    private String username;
    private String password;

    public LoginUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ResponseDto execute() {
        // TODO: generate authToken and store it in cache

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent("user logged in");

        return responseDto;
    }
}
