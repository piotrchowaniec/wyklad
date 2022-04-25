package info.fingo.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void toJson() throws JsonProcessingException {

        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setOrderedItems(List.of(new OrderedItem(1234L, "Jakis produkt", BigDecimal.TEN)));

        String valueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
        System.out.println(valueAsString);

        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 8);
        map.put("key2", 111);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
    }

    @Test
    void fromJson() throws JsonProcessingException {
        String json = """
                {
                    "id": 6,
                    "unknownField" : "some value",
                    "orderTime": "28-02-2022 03:23",
                    "deliveryAddress": {
                        "street": "731 Spinka Shores",
                        "city": "Goodwinview",
                        "zipCode": "66960-3008"
                    },
                    "orderedItems": [
                        {
                            "productId": 3121,
                            "productName": "Rustic Paper Bag",
                            "price": 18.94
                        },
                        {
                            "productId": 5870529,
                            "productName": "Incredible Plastic Lamp",
                            "price": 38.15
                        },
                        {
                            "productId": 2,
                            "productName": "Sleek Wooden Bottle",
                            "price": 68.85
                        },
                        {
                            "productId": 515607121,
                            "productName": "Incredible Wool Keyboard",
                            "price": 98.84
                        },
                        {
                            "productId": 21044835,
                            "productName": "Fantastic Granite Car",
                            "price": 46.60
                        }
                    ]
                }
                """;

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Order order = mapper.readValue(json, Order.class);
        System.out.println(order);
    }
}