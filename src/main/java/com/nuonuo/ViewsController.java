package com.nuonuo;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller("/doc")
class ViewsController {
    
    @Value(value = "${micronaut.swagger.filename:application.yml}")
    String fileName;

    @View("swagger/ui")
    @Get("/swagger")
    public HttpResponse swagger() {
        return HttpResponse.ok(CollectionUtils.mapOf("fileName", fileName));
    }
    
    @View("redoc/ui")
    @Get("/redoc")
    public HttpResponse redoc() {
        return HttpResponse.ok(CollectionUtils.mapOf("fileName", fileName));
    }

}
