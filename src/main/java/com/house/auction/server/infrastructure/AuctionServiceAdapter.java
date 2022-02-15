package com.house.auction.server.infrastructure;

import com.house.auction.server.auction.AuctionEntity;
import com.house.auction.server.auction.AuctionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceAdapter implements AuctionService {

    @Override
    public void createAuction(AuctionEntity auction) {

    }

    @Override
    public void bidAuction(int auctionId, int value, int bidBy) {

    }

    @Override
    public AuctionEntity getById(int auctionId) {
        return null;
    }

    @Override
    public List<AuctionEntity> searchByStatus(int status) {
        return null;
    }
}
