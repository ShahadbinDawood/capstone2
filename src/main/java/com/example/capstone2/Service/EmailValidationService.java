package com.example.capstone2.Service;


import com.example.capstone2.Api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailValidationService {
    @Value("${abstract.api.key}")
    private String apiKey;
    public boolean isValidEmail(String email) {
        String url = "https://emailvalidation.abstractapi.com/v1/?api_key="
                + apiKey + "&email=" + email;

        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(url, String.class);
            // الـ API يرجع JSON فيه "deliverability": "DELIVERABLE"
            return response.contains("\"deliverability\":\"DELIVERABLE\"");
        } catch (Exception e) {
            throw new ApiException("Email validation failed");
        }
    }
}
