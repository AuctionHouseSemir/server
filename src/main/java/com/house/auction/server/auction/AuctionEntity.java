package com.house.auction.server.auction;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class AuctionEntity {
    private int id;
    private String auctionName;
    private double initialPrice;
    private double minPrice;
    private int duration;
    private int status;
    private int createdBy;
    private LinkedList<BidEntity> bids = new LinkedList<>();
}
