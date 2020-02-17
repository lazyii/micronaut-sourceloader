package com.nuonuo.service.impl;

import com.nuonuo.model.AuthUser;
import com.nuonuo.repository.AuthUserRepository;
import com.nuonuo.service.AuthUserService;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.CollectionUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by admin on 2019/12/23 9:58:04.
 */
@Singleton
@Requires(beans = AuthUserRepository.class)
public class AuthUserServiceImpl implements AuthUserService {
    @Inject
    AuthUserRepository authUserRepository;
    
    @Override
    public List<AuthUser> getAllUser() {
        Iterable<AuthUser> user = authUserRepository.findAll();
        return CollectionUtils.iterableToList(user);
    }
}
