package io.swagger.api.factories;

import io.swagger.api.StoreApiService;
import io.swagger.api.impl.StoreApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T14:13:48.751063566Z[GMT]")
public class StoreApiServiceFactory {
    private final static StoreApiService service = new StoreApiServiceImpl();

    public static StoreApiService getStoreApi() {
        return service;
    }
}
