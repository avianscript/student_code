package com.techelevator;

public class Music extends MediaItem {
    private String artist;
    private int numOfTracks;

    public String getArtist() {
        return this.artist;
    }

    public int getNumOfTracks() {
        return this.numOfTracks;
    }

    public void setArtist(String lastName, String firstName) {
        this.artist = lastName + firstName;
    }

    public void setNumOfTracks(int tracks) {
        this.numOfTracks = tracks;
    }

    public Music(String title, String artist, int numOfTracks, double price) {
        this.title = title;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
        this.price = price;
    }
}
