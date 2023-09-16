package com.Eragoo.fulltexttest.config;


import org.hibernate.dialect.PostgreSQL82Dialect;

public class CustomPostgreSQLDialect extends PostgreSQL82Dialect {
    public CustomPostgreSQLDialect() {
        super();
        registerFunction("tsvector_match", new TsVectorMatchExpression());
    }
}
