package com.house.auction.server.auction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BidEntity {
    private int auctionId;
    private int value;
    private int bidBy;
}
