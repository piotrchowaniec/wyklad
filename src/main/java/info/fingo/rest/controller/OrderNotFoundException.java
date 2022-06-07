package info.fingo.rest.controller;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID orderId) {
        super(String.format("Order with id: %s was not found", orderId));
    }
}
