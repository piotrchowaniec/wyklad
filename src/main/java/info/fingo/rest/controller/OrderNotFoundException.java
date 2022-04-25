package info.fingo.rest.controller;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super(String.format("Order with id: %s was not found", orderId));
    }
}
