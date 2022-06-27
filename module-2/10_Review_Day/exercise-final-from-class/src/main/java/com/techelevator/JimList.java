package com.techelevator;

import com.techelevator.model.Campground;

import java.util.ArrayList;

public class JimList extends ArrayList<Campground> {


    @Override
    public boolean add(Campground campground) {
        campground.setName(campground.getName() + "Jim!!!");
        return super.add(campground);
    }
}
