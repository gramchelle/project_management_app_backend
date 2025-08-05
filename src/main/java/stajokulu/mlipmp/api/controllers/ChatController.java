package stajokulu.mlipmp.api.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/chatbot")
public class ChatController {

    @PostMapping("/sendMessage")
    public ResponseEntity<String> chatWithBot(@RequestBody Map<String, String> body) {
        String userMessage = body.get("message");

        // Python chatbot servisine POST isteği hazırlığı
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> payload = new HashMap<>();
        payload.put("user_message", userMessage);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    "http://localhost:8001/chat", entity, Map.class);

            String botReply = (String) response.getBody().get("bot_response");

            return ResponseEntity.ok(botReply);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Chatbot servisinden cevap alınamadı: " + e.getMessage());
        }
    }
}
