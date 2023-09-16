package com.Eragoo.fulltexttest.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class ProductOutputDto {
    private final Long id;
    private final String title;
    private final Instant createdAt;

    public ProductOutputDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.createdAt = product.getCreatedAt();
    }
}
