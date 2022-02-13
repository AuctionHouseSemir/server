package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class BidCommand implements Command {
    private int auctionId;
    private int bidValue;
    private int userId;

    public BidCommand(int auctionId, int bidValue, int userId) {
        this.auctionId = auctionId;
        this.bidValue = bidValue;
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: add new bid record for auction by user in db (auction_bids_table)

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d bid for auction %d", this.userId, this.auctionId));

        return responseDto;
    }
}
