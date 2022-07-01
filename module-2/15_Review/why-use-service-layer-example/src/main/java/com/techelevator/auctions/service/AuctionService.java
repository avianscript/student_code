package com.techelevator.auctions.service;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import java.util.List;

public class AuctionService {

    private AuctionDao dao;

    // constructor uses dependency injection to inject AuctionDao
    public AuctionService(AuctionDao dao) {
        this.dao = dao;
    }

    public Auction get(int id) throws AuctionNotFoundException {
        return dao.get(id);
    }

    public Auction create(Auction auction) {
        return dao.create(auction);
    }

    public List<Auction> list(String title_like, double currentBid_lte) {

        if( !title_like.equals("") ) {
            return dao.searchByTitle(title_like);
        }
        if(currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();
    }
}
