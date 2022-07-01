package com.techelevator.memes.service;

import com.techelevator.memes.model.*;
import com.techelevator.memes.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemeGeneratorService {

    private static final String API_BASE_URL = "https://api.imgflip.com/";
    private static final String API_USERNAME = "ym.phl.te.class.tests";
    private static final String API_PASSWORD = "NpaPrwkTrE4yJY";

    private final MemeUtils memeUtils;
    private RestTemplate restTemplate;

    public MemeGeneratorService() {
        this.memeUtils = new MemeUtils();
        this.restTemplate = new RestTemplate();
    }

    public List<MemeListItem> getMemeList() {

        List<MemeListItem> memeList = new ArrayList<>();

        // add code to call get_memes endpoint
        //
        // It will call the get_memes and receive a MemeApiGetResponse



        // Once you have the MemeApiGetResponse, use the Meme[] in the MemeApiGetResponse
        // to populate the List of MemeListItems which only use the id and name of each Meme

        try {
            MemeApiGetResponse response = restTemplate.getForObject(API_BASE_URL + "get_memes", MemeApiGetResponse.class);
            if (response != null && response.getData() != null) {
                for (Meme meme : response.getData().getMemes()) {
                    MemeListItem item = new MemeListItem();
                    item.setMemeId(meme.getId());
                    item.setMemeName(meme.getName());
                    memeList.add(item);
                }
            }
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error getting memes: " + ex.getRawStatusCode() + " " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log("Error getting memes: " + ex.getMessage());
        }



        return memeList;
    }

    /**
     * Uses caption_image endpoint to create meme and return URL
     * @param info
     * @return String
     */
    public String createMeme(CreateMemeInfo info) {
        CaptionedMeme newMeme = new CaptionedMeme();
        newMeme.setTemplateId(info.getMemeId());
        newMeme.setTopText(info.getCaption());
        newMeme.setUsername(API_USERNAME);
        newMeme.setPassword(API_PASSWORD);

        MultiValueMap<String, String> formData = memeUtils.formDataFromCaptionedMeme(newMeme);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);

        try {
            MemeApiCreateResponse response = restTemplate.postForObject(API_BASE_URL + "caption_image", entity, MemeApiCreateResponse.class);
            if (response != null && response.getData() != null) {
                return response.getData().getUrl();
            }
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error creating meme: " + ex.getRawStatusCode() + " " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log("Error creating meme: " + ex.getMessage());
        }

        return null;
    }
}
