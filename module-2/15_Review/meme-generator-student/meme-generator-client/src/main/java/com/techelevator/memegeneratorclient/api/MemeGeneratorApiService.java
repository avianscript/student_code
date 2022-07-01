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

        return null;
    }

    public String createMeme(String memeId, String caption) {

        return null;
    }
}
