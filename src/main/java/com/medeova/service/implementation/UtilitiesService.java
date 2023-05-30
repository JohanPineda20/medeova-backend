package com.medeova.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UtilitiesService 
{
    private final RestTemplate restTemplate;

    public UtilitiesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getJsonData(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
