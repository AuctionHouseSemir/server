package com.house.auction.server.commands.auth;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class RegisterUserCommand implements Command {
    private String username;
    private String password;

    public RegisterUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ResponseDto execute() {
        // TODO: store user in db (users_table)

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %s registered", this.username));

        return responseDto;
    }
}