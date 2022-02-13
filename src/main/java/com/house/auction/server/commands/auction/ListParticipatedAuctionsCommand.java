package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class ListParticipatedAuctionsCommand implements Command {
    private int userId;

    public ListParticipatedAuctionsCommand(int userId) {
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: get all participated auctions from db (auctions_table)

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d requested participated auctions", this.userId));

        return responseDto;
    }
}
