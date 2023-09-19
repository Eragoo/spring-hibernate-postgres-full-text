package com.Eragoo.fulltexttest.product;

import io.hypersistence.utils.hibernate.type.search.PostgreSQLTSVectorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;
import java.time.Instant;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {
    private static final String GENERATOR = "product_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = "product_sequence")
    private Long id;

    private String title;

    private Instant createdAt;

    @Type(PostgreSQLTSVectorType.class)
    @Column(name = "title_search_vector",columnDefinition = "tsvector")
    private String titleSearchVector;
}
