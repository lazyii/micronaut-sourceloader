package com.nuonuo;

import com.nuonuo.service.BookService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

/**
 * Created by admin on 2019/12/20 12:29:33.
 */
@Controller(value = "/hello")
public class HelloController {

//    @Inject
//    private DataSource      dataSource;
//    @Inject
//    private JdbcBookService jdbcBookService;
    @Inject
    private BookService bookService;
    
    @Get(value = "/p")
    public String p() {
        return "Hello World";
    }
    
    @Get(value = "/service")
    public String service() {
        String hello = bookService.hello();
        return hello;
    }
}
