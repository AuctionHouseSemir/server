package com.house.auction.server.commands.invalid;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class InvalidCommand implements Command {
    private String message;

    public InvalidCommand() {
        this.message = "invalid command";
    }

    public InvalidCommand(String message) {
        this.message = message;
    }

    @Override
    public ResponseDto execute() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Error);
        responseDto.setContent(this.message);

        return responseDto;
    }
}
