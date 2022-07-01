package com.techelevator.memegeneratorclient.api;

import com.techelevator.memegeneratorclient.model.CreateMemeInfo;
import com.techelevator.memegeneratorclient.model.Meme;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


@Service
public class MemeGeneratorApiService {

    private static final String BASE_API_URL = "http://localhost:8080/";

    private RestTemplate restTemplate;

    public MemeGeneratorApiService() {
        this.restTemplate = new RestTemplate();
    }

    public Meme[] getMemes() {
        Meme[] memes = restTemplate.getForObject(BASE_API_URL + "memes", Meme[].class);
        return memes;
    }

    public String createMeme(String memeId, String caption) {
        CreateMemeInfo info = new CreateMemeInfo();
        info.setMemeId(memeId);
        info.setCaption(caption);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON.toString());
//        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateMemeInfo> entity = new HttpEntity<>(info, headers);



        String imageUrl = restTemplate.postForObject(BASE_API_URL + "memes", entity, String.class);
        return imageUrl;
    }
}
