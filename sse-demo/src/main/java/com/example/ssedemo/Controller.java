package com.example.ssedemo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@AllArgsConstructor
public class Controller {

    private final ClientService clientService;

    @CrossOrigin
    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        return clientService.create();
    }

    @GetMapping("/message")
    public ResponseEntity<Object> sendMessage() {
        String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
        clientService.castMessage(message);

        return ResponseEntity.ok().build();
    }
}
