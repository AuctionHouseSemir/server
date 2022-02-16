package com.house.auction.server.adapters;

import com.house.auction.server.auction.AuctionEntity;
import com.house.auction.server.auction.BidEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuctionServiceAdapterTests {
    private AuctionServiceAdapter auctionServiceAdapter;

    @Before
    public void setup() {
        auctionServiceAdapter = new AuctionServiceAdapter();
    }

    @Test
    public void createAuction() {
        AuctionEntity auction = new AuctionEntity();
        auction.setAuctionName("auction_a");
        auction.setDuration(2);
        auction.setInitialPrice(5);
        auction.setMinPrice(10);
        auction.setStatus(0);
        auction.setCreatedBy(1);

        auctionServiceAdapter.createAuction(auction);

        AuctionEntity auctionCreated = auctionServiceAdapter.getById(1);

        Assert.assertNotNull(auctionCreated);
        Assert.assertEquals(1, auctionCreated.getId());
        Assert.assertEquals("auction_a", auctionCreated.getAuctionName());
        Assert.assertEquals(0, auctionCreated.getBids().size());
    }

    @Test
    public void bidAuction() {
        AuctionEntity auction = new AuctionEntity();
        auction.setAuctionName("auction_a");
        auction.setDuration(2);
        auction.setInitialPrice(5);
        auction.setMinPrice(10);
        auction.setStatus(0);
        auction.setCreatedBy(1);

        auctionServiceAdapter.createAuction(auction);
        auctionServiceAdapter.bidAuction(1, 5, 1);

        AuctionEntity updatedAuction = auctionServiceAdapter.getById(1);
        Assert.assertEquals(1, updatedAuction.getBids().size());

        BidEntity bid = updatedAuction.getBids().stream().findFirst().orElse(null);
        Assert.assertNotNull(bid);
        Assert.assertEquals(5, bid.getValue());
    }
}
