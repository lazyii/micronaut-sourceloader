package com.nuonuo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by admin on 2019/12/20 12:29:33.
 */
@Controller(value = "/data")
public class DatasourceController {
    
    @Inject
    private DataSource dataSource;
    
    @Get(value = "/datasource")
    public String datasource() {
    
        try {
            int key = ThreadLocalRandom.current().nextInt();
            Boolean b = dataSource.getConnection().prepareStatement("insert into naut_person values("+key+",'nameaaa','adressaa')").execute();
            return b.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
