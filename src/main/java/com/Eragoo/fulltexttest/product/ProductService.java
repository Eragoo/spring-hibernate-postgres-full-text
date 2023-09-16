package com.Eragoo.fulltexttest.product;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductOutputDto> getAll(ProductFilter filter, Pageable pageable) {
        return productRepository.findAll(filter.toPredicate(), pageable)
                .map(ProductOutputDto::new);
    }
}
