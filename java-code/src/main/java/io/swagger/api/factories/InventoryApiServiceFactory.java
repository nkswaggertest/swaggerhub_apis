package io.swagger.api.factories;

import io.swagger.api.InventoryApiService;
import io.swagger.api.impl.InventoryApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T15:16:15.468392484Z[GMT]")
public class InventoryApiServiceFactory {
    private final static InventoryApiService service = new InventoryApiServiceImpl();

    public static InventoryApiService getInventoryApi() {
        return service;
    }
}
