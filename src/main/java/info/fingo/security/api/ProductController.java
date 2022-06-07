package info.fingo.security.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(new Product(1L, "book"));
        PRODUCTS.add(new Product(2L, "bike"));
        PRODUCTS.add(new Product(3L, "flower"));
    }

    @GetMapping
    public List<Product> getAll() {
        return PRODUCTS;
    }

    @GetMapping("/{productId}")
    public Product getById(@RequestParam Long productId) {
        return PRODUCTS.stream()
                .filter(product -> Objects.equals(product.id(), productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Product with id %s not found", productId)));
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        PRODUCTS.add(product);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") Long productId) {
        PRODUCTS.removeIf(product -> Objects.equals(product.id(), productId));
    }
}
