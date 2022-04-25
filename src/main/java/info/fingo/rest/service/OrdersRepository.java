package info.fingo.rest.service;

import com.github.javafaker.Faker;
import info.fingo.rest.model.Address;
import info.fingo.rest.model.Order;
import info.fingo.rest.model.OrderedItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class OrdersRepository {

    private final List<Order> orders = new ArrayList<>();

    private final IdGenerator idGenerator;

    public OrdersRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order save(Order order) {
        order.setId(idGenerator.generateId());
        orders.add(order);
        return order;
    }

    public void delete(Long orderId) {
        orders.removeIf(it -> Objects.equals(it.getId(), orderId));
    }

    public Optional<Order> findById(Long orderId) {
        return orders.stream().filter(it -> Objects.equals(it.getId(), orderId)).findFirst();
    }


    @PostConstruct
    public void initialize() {
        Faker faker = new Faker();
        for (long l = 1; l < 5; l++) {
            Order order = new Order();

            Address address = new Address();
            address.setCity(faker.address().city());
            address.setStreet(faker.address().streetAddress());
            address.setZipCode(faker.address().zipCode());
            order.setDeliveryAddress(address);

            order.setOrderTime(LocalDateTime.from(faker.date().past(1_000, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault())));

            int itemsCount = faker.random().nextInt(10) + 1;
            List<OrderedItem> items = new ArrayList<>(itemsCount);
            for (int i = 1; i < itemsCount; i++) {
                String price = faker.commerce().price();
                items.add(new OrderedItem(faker.number().randomNumber(), faker.commerce().productName(), new BigDecimal(price.replace(',', '.'))));
            }
            order.setOrderedItems(items);

            save(order);
        }
    }

    public Order update(Order order) {
        return null;
    }
}
