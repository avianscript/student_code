package com.techelevator.memes.model;

import java.util.List;

/**
 * Class to hold data from get_memes endpoint
 */
public class MemeData {

    private List<Meme> memes;

    public List<Meme> getMemes() {
        return memes;
    }

    public void setMemes(List<Meme> memes) {
        this.memes = memes;
    }
}
