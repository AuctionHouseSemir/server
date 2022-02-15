package com.house.auction.server.commands.invalid;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class InvalidCommandParameters implements Command {

    @Override
    public ResponseDto execute() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Error);
        responseDto.setContent("invalid command parameters");

        return responseDto;
    }
}
