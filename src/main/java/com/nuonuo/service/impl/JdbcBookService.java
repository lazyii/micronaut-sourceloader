package com.nuonuo.service.impl;

import com.nuonuo.service.BookService;
import io.micronaut.context.annotation.Requires;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
@Requires(beans = DataSource.class)
public class JdbcBookService implements BookService {
    
    @Inject
    DataSource dataSource;
    
    public JdbcBookService(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public String hello() {
        return "hello";
    }
}
