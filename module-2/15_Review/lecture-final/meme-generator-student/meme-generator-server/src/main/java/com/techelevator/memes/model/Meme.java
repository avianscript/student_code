package com.techelevator.memes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to hold meme item from get_memes endpoint
 */
public class Meme {

    private String id;
    private String name;
    private Integer width;
    private Integer height;
    @JsonProperty("box_count")
    private Integer boxCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(Integer boxCount) {
        this.boxCount = boxCount;
    }
}
