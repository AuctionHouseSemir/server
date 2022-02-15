package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class ListExpiredAuctionsCommand implements Command {
    private int userId;

    public ListExpiredAuctionsCommand(int userId) {
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: get all expired auctions from db (auctions_table)

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d requested expired auctions", this.userId));

        return responseDto;
    }
}
