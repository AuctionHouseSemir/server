package com.house.auction.server.adapters;

import com.house.auction.server.auction.AuctionEntity;
import com.house.auction.server.auction.AuctionService;
import com.house.auction.server.auction.BidEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AuctionServiceAdapter implements AuctionService {
    private final CopyOnWriteArrayList<AuctionEntity> auctions;
    private final AtomicInteger auctionsCounter;

    public AuctionServiceAdapter() {
        this.auctions = new CopyOnWriteArrayList<>();
        this.auctionsCounter = new AtomicInteger();
    }

    @Override
    public void createAuction(AuctionEntity auction) {
        auction.setId(auctionsCounter.incrementAndGet());
        auctions.add(auction);
    }

    @Override
    public void bidAuction(int auctionId, int value, int bidBy) {
        AuctionEntity auction = getById(auctionId);
        BidEntity bid = new BidEntity();
        bid.setAuctionId(auctionId);
        bid.setValue(value);
        bid.setBidBy(bidBy);

        auction.getBids().add(bid);
    }

    @Override
    public AuctionEntity getById(int auctionId) {
        return auctions.stream()
                .filter(a -> a.getId() == auctionId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AuctionEntity> searchByStatus(int status, int userId) {
        return auctions.stream()
                .filter(a -> a.getStatus() == status && a.getCreatedBy() == userId)
                .toList();
    }
}
