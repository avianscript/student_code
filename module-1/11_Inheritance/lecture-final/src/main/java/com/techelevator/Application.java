package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Auction> auctions = new ArrayList<>();

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        auctions.add(generalAuction);

        Bid joshBid = new Bid("Josh", 1);
        generalAuction.placeBid(joshBid);
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        Bid generalAuctionWinningBid = generalAuction.getHighBid();
        String winner = generalAuctionWinningBid != null ? generalAuctionWinningBid.getBidder() : "No info available";
        int winningAmount = generalAuctionWinningBid.getBidAmount();

        System.out.println("Winner of general auction is "
                + (generalAuction.getHighBid() != null ? generalAuction.getHighBid() : "No info available")
                + " Final sale price: $" + winningAmount);


        Auction reserveAuction = new ReserveAuction("Yoav's Coke Zero Bottle", 100);
        Bid bottleBid1 = new Bid("Andrea", 10);
        reserveAuction.placeBid(bottleBid1);
        Bid bottleBid2 = new Bid("Jim", 125);
        reserveAuction.placeBid(bottleBid2);
        Bid bottleBid3 = new Bid("Amber", 101);
        reserveAuction.placeBid(bottleBid3);

        auctions.add(reserveAuction);


        Auction buyoutAuction = new BuyoutAuction("Calculstor", 50);
        Bid calc1 = new Bid("Andrea", 10);
        buyoutAuction.placeBid(bottleBid1);
        Bid calc2 = new Bid("Jim", 125);
        buyoutAuction.placeBid(bottleBid2);
        Bid calc3 = new Bid("Amber", 101);
        buyoutAuction.placeBid(bottleBid3);

        auctions.add(buyoutAuction);


        for (Auction curAuction : auctions) {

            String itemForSale = curAuction.getItemForSale();

            System.out.println("Item: " + curAuction.getItemForSale() + " Winner: " + curAuction.getHighBid().getBidder()
            + " Final Sale Amount: $" + curAuction.getHighBid().getBidAmount());

//            curAuction.p
       }



    }
}
