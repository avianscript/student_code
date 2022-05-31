package com.techelevator;

public class BuyoutAuction extends Auction {

    private int buyoutAmount;

    public BuyoutAuction(String itemForSale, int buyoutAmount) {
        super(itemForSale);
        this.buyoutAmount = buyoutAmount;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (getHighBid().getBidAmount() < buyoutAmount) {

            if (offeredBid.getBidAmount() > buyoutAmount) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutAmount);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

    public void printYoav() {
        System.out.println("I'm Yoav!");
    }
}
