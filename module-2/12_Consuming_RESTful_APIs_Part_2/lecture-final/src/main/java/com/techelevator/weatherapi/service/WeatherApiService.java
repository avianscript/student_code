package com.techelevator.weatherapi.service;

import com.techelevator.util.BasicLogger;
import com.techelevator.weatherapi.model.alerts.AlertResponse;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class WeatherApiService {

    private static final String BASE_URL = "https://api.weather.gov/alerts/active/area/";

    private RestTemplate restTemplate = new RestTemplate();


    public void getAlertData(String stateCode) {

        String url = BASE_URL + stateCode;

        try {
            AlertResponse response = restTemplate.getForObject(url, AlertResponse.class);
            System.out.println();
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error: " + ex.getRawStatusCode() + " " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }

    }
}
