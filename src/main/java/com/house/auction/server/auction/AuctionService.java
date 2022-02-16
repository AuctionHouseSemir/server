package com.house.auction.server.auction;

import java.util.List;

public interface AuctionService {
    void createAuction(AuctionEntity auction);
    void bidAuction(int auctionId, int value, int bidBy);
    AuctionEntity getById(int auctionId);
    List<AuctionEntity> searchByStatus(int status, int userId);
}
