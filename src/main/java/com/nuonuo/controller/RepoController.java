package com.nuonuo.controller;

import com.nuonuo.model.AuthUser;
import com.nuonuo.service.AuthUserService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by admin on 2019/12/20 12:29:33.
 */
@Controller(value = "/authuser")
public class RepoController {
    
    @Inject
    private AuthUserService authUserService;
    
    @Get(value = "/all")
    public List<AuthUser> jpa() {
//        PHYSICAL_NAMING_STRATEGY
//        io.micronaut.data.hibernate.naming.DefaultPhysicalNamingStrategy
        List<AuthUser> list = authUserService.getAllUser();
        return list;
    }
}
