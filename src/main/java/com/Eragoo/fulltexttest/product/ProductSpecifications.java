package com.Eragoo.fulltexttest.product;

import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class ProductSpecifications {

    public static Specification<Product> search(String search) {
        return (root, query, cb) -> {
            if (search == null || search.isBlank()) return null;

            return cb.isTrue(
                    cb.function(
                            "tsvector_match",
                            Boolean.class,
                            root.get(Product_.titleSearchVector),
                            cb.function("plainto_tsquery", String.class, cb.literal(search))
                    )
            );
        };
    }


    public static Specification<Product> createdAtFrom(Instant createdAtFrom) {
        return (root, query, cb) -> createdAtFrom == null ? null :
                cb.greaterThanOrEqualTo(root.get(Product_.createdAt), createdAtFrom);
    }

    public static Specification<Product> createdAtTo(Instant createdAtTo) {
        return (root, query, cb) -> createdAtTo == null ? null :
                cb.lessThanOrEqualTo(root.get(Product_.createdAt), createdAtTo);
    }
}
