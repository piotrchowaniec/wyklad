package info.fingo.rest.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerator {

    public UUID generateId() {
        return UUID.randomUUID();
    }
}
