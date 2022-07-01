package com.techelevator.memes.service;

import com.techelevator.memes.model.*;
import com.techelevator.memes.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MemeGeneratorService {

    private static final String API_BASE_URL = "https://api.imgflip.com/";
    private static final String API_USERNAME = "ym.phl.te.class.tests";
    private static final String API_PASSWORD = "NpaPrwkTrE4yJY";

    private final RestTemplate restTemplate;
    private final MemeUtils memeUtils;

    public MemeGeneratorService() {
        this.restTemplate = new RestTemplate();
        this.memeUtils = new MemeUtils();
    }

    public List<MemeListItem> getMemeList() {

        List<MemeListItem> memeList = new ArrayList<>();

        // add code to call get_memes endpoint
        //
        // It will call the get_memes and receive a MemeApiGetResponse


        // Once you have the MemeApiGetResponse, use the Meme[] in the MemeApiGetResponse
        // to populate the List of MemeListItems which only use the id and name of each Meme


        return memeList;
    }

    /**
     * Uses caption_image endpoint to create meme and return URL
     * @param info
     * @return String
     */
    public String createMeme(CreateMemeInfo info) {

        return null;
    }
}
