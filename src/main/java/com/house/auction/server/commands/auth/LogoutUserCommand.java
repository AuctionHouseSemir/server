package com.house.auction.server.commands.auth;

import com.house.auction.server.auth.AuthToken;
import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class LogoutUserCommand implements Command {
    private AuthToken authToken;

    public LogoutUserCommand(AuthToken authToken) {
        this.authToken = authToken;
    }

    @Override
    public ResponseDto execute() {
        // TODO: destroy user authToken from cache

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent("user logged out");

        return responseDto;
    }
}
