package com.techelevator;

public class ReserveAuction extends Auction {

    private int reserveAmount;

    public ReserveAuction(String itemForSale, int reserveAmount) {
        super(itemForSale);
        this.reserveAmount = reserveAmount;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reserveAmount) {
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    @Override
    public String getItemForSale() {
        return "Blah!";
    }
}
