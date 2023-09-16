package com.Eragoo.fulltexttest.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class ProductFilter {
    private final String search;
    private final Instant createdAtFrom;
    private final Instant createdAtTo;

    public Specification<Product> toPredicate() {
        return ProductSpecifications.createdAtFrom(createdAtFrom)
                .and(ProductSpecifications.createdAtTo(createdAtTo))
                .and(ProductSpecifications.search(search));
    }
}
