package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class ListWonAuctionsCommand implements Command {
    private int userId;

    public ListWonAuctionsCommand(int userId) {
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: get all won auctions from db (auctions_table)

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d requested won auctions", this.userId));

        return responseDto;
    }
}
