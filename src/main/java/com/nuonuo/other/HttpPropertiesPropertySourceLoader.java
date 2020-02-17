package com.nuonuo.other;

import io.micronaut.context.env.AbstractPropertySourceLoader;
import io.micronaut.context.env.EnvironmentPropertySource;
import io.micronaut.core.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by admin on 2019/12/20 17:38:45.
 */
public class HttpPropertiesPropertySourceLoader extends AbstractPropertySourceLoader {
    
    /**
     * Default position for the property source loader.
     */
    public static final int DEFAULT_POSITION = EnvironmentPropertySource.POSITION + 300;
    
    /**
     * File extension for property source loader.
     */
    @Override
    public Set<String> getExtensions() {
        return CollectionUtils.setOf("properties");
    }
    
    @Override
    protected void processInput(String name, InputStream input, Map<String, Object> finalMap) throws IOException {
        //判断inupt类型，
        boolean enabled = (Boolean) finalMap.getOrDefault("nuonuo.config.enabled", false);
        //todo 需要删除这个
        finalMap.put("nuonuo.aa.bb", "bbbbbbbbbbbbbbbbbbbbbbb");
        if (enabled) {
            String url = finalMap.get("nuonuo.config.server").toString();
            String id = finalMap.get("nuonuo.config.app-id").toString();
            String random = finalMap.get("nuonuo.config.app-random").toString();
            String instanceId = finalMap.get("nuonuo.config.instance-id").toString();
            //read file from nuonuo config center, 这里模拟已经获取 db 配置
            finalMap.put("datasources.default.url", "jdbc:mysql://192.168.0.130/micronaut");
            finalMap.put("datasources.default.driverClassName", "com.mysql.cj.jdbc.Driver");
            finalMap.put("datasources.default.username", "root");
            finalMap.put("datasources.default.password", "wangyudi");
            finalMap.put("datasources.default.dialect", "MYSQL");
            finalMap.put("datasources.default.minimumIdle", "5");
            finalMap.put("datasources.default.maximumPoolSize", "20");
            finalMap.put("datasources.default.connectionTestQuery", "select 1");
        }
    }
    
    @Override
    public int getOrder() {
        return DEFAULT_POSITION;
    }
    
}
