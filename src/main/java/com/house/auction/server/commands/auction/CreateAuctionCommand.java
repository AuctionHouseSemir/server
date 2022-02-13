package com.house.auction.server.commands.auction;

import com.house.auction.server.commands.Command;
import com.house.auction.server.commands.ResponseDto;
import com.house.auction.server.commands.ResponseStatus;

public class CreateAuctionCommand implements Command {
    private String auctionName;
    private double initialPrice;
    private double minPrice;
    private int duration;
    private int userId;

    public CreateAuctionCommand(String auctionName, double initialPrice, double minPrice, int duration, int userId) {
        this.auctionName = auctionName;
        this.initialPrice = initialPrice;
        this.minPrice = minPrice;
        this.duration = duration;
        this.userId = userId;
    }

    @Override
    public ResponseDto execute() {
        // TODO: create new auction record for user in db (auctions_table)

        ResponseDto responseDto = new ResponseDto();

        responseDto.setStatus(ResponseStatus.Ok);
        responseDto.setContent(String.format("user %d created auction %s", this.userId, this.auctionName));

        return responseDto;
    }
}
