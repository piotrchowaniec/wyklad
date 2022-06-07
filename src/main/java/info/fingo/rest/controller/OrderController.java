package info.fingo.rest.controller;

import info.fingo.rest.service.OrdersRepository;
import info.fingo.rest.model.Order;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;

/**
 *
 * REST defines 6 architectural constraints which make any web service – a truly RESTful API.
 *
 * Uniform interface
 * Client–server
 * Stateless
 * Cacheable
 * Layered system
 * Code on demand (optional)
 *
 */

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrdersRepository ordersRepository;

    public OrderController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping
    public List<Order> getAll() {
        return ordersRepository.getAll();
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return ordersRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable UUID orderId) {
        ordersRepository.delete(orderId);
    }

    @GetMapping("/{orderId}")
    public Order getById(@PathVariable UUID orderId) {
        return ordersRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@RequestBody Order newOrder, @PathVariable UUID id) {
        return ordersRepository.findById(id)
                .map(order -> {
                    order.setOrderTime(newOrder.getOrderTime());
                    order.setDeliveryAddress(newOrder.getDeliveryAddress());
                    order.setOrderedItems(newOrder.getOrderedItems());
                    return ordersRepository.update(order);
                })
                .orElseGet(() -> ordersRepository.save(newOrder));
    }

}
