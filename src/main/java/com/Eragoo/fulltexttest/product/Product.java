package com.Eragoo.fulltexttest.product;

import com.vladmihalcea.hibernate.type.search.PostgreSQLTSVectorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;


@TypeDef(name = "tsvector", typeClass = PostgreSQLTSVectorType.class)
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

    @Type(type = "tsvector")
    @Column(name = "title_search_vector",columnDefinition = "tsvector")
    private String titleSearchVector;
}
