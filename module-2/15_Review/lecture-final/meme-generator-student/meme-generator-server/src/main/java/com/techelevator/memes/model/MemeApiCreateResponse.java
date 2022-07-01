package com.techelevator.memes.model;

/**
 * Response from caption_image API endpoint
 */
public class MemeApiCreateResponse {

    private boolean success;
    private UrlInfo data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UrlInfo getData() {
        return data;
    }

    public void setData(UrlInfo data) {
        this.data = data;
    }
}
