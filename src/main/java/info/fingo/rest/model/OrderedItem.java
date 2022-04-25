package info.fingo.rest.model;

import java.math.BigDecimal;

public record OrderedItem(Long productId,
     String productName,
     BigDecimal price) {}
