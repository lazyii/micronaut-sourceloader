package com.nuonuo.other;

import io.micronaut.context.env.AbstractPropertySourceLoader;
import io.micronaut.core.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2019/12/20 17:38:45.
 */
public class HttpYmlPropertySourceLoader extends AbstractPropertySourceLoader {
    
    /**
     * Default position for the property source loader.
     */
    private static final Logger LOG = LoggerFactory.getLogger(HttpYmlPropertySourceLoader.class);
    
    
    /**
     * File extension for property source loader.
     */
    @Override
    public Set<String> getExtensions() {
        return CollectionUtils.setOf("yml", "yaml");
    }
    
    @Override
    protected void processInput(String name, InputStream input, Map<String, Object> finalMap) throws IOException {
        //读取input内容，
        Yaml             yaml    = new Yaml();
        Map<String, Object> tempMap = new HashMap<>();
        Iterable<Object> objects = yaml.loadAll(input);
        Iterator<Object> i       = objects.iterator();
        if (i.hasNext()) {
            while (i.hasNext()) {
                Object object = i.next();
                if (object instanceof Map) {
                    Map map = (Map) object;
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("Processing YAML: {}", map);
                    }
                    String prefix = "";
                    processMap(tempMap, map, prefix);
                }
            }
        } else {
            if (LOG.isTraceEnabled()) {
                LOG.trace("PropertySource [{}] produced no YAML content", name);
            }
        }
        boolean enabled = (Boolean) tempMap.getOrDefault("nuonuo.config.enabled", false);
        if (enabled) {
            String url = tempMap.get("nuonuo.config.server").toString();
            String id = tempMap.get("nuonuo.config.app-id").toString();
            String random = tempMap.get("nuonuo.config.app-random").toString();
            String instanceId = tempMap.get("nuonuo.config.instance-id").toString();
            //read file from nuonuo config center, 这里模拟已经获取 db 配置
//            finalMap.put("datasources.default.url", "jdbc:mysql://192.168.0.130/micronaut");
            finalMap.put("datasources.default.url", "jdbc:mysql://172.30.11.70:3308/nnauth?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false");
            finalMap.put("datasources.default.driverClassName", "com.mysql.cj.jdbc.Driver");
            finalMap.put("datasources.default.username", "dev");
            finalMap.put("datasources.default.password", "dev123456");
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
