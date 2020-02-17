package com.nuonuo.repository;

import com.nuonuo.model.AuthUser;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

/**
 * Created by admin on 2019/12/22 0:57:30.
 */
@JdbcRepository(dialect = Dialect.MYSQL)
public interface AuthUserRepository extends CrudRepository<AuthUser, Integer> {

}
