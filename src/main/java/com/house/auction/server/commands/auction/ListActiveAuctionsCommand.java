package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class ListActiveAuctionsCommand implements Command {
    private int userId;

    public ListActiveAuctionsCommand(int userId) {
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: get all active auctions from db (auctions_table)

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d requested active auctions", this.userId));

        return responseDto;
    }
}
