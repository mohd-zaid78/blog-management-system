package com.zaid.blog_management_system.openAIservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Value("${openai.model}")
    private String model;

    private final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public String summarizeText(String text) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiApiKey);

        // OpenAI request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", model);
        requestBody.put("messages", Arrays.asList(
                Map.of("role", "system", "content", "You are a helpful assistant that summarizes text."),
                Map.of("role", "user", "content", "Summarize this: " + text)
        ));
        requestBody.put("max_tokens", 100);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(OPENAI_URL, HttpMethod.POST, entity, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");

            return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");

        } catch (Exception e) {
            return "AI summarization failed: " + e.getMessage();
        }
    }
    
   

}
