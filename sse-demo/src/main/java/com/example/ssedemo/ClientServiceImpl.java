package com.example.ssedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final List<SseEmitter> sseEmitters;

    public ClientServiceImpl() {
        sseEmitters = new ArrayList<>();
    }

    @Override
    public SseEmitter create() {
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
        sseEmitters.add(sseEmitter);
        return sseEmitter;
    }

    @Override
    public void castMessage(String message) {
        for (Iterator<SseEmitter> iterator = sseEmitters.iterator(); iterator.hasNext();) {
            try {
                SseEmitter sseEmitter = iterator.next();
                sseEmitter.send(message);
            } catch (IOException ioException) {
                log.error("IOException: {}", ioException.getMessage());
                iterator.remove();
                log.info("Remove sseEmitter. Emitters size: {}", this.sseEmitters.size());
            }
        }
    }
}
