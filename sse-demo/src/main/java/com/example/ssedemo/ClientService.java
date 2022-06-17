package com.example.ssedemo;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ClientService {
    SseEmitter create();

    void castMessage(String message);
}
