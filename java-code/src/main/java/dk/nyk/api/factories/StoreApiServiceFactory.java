package dk.nyk.api.factories;

import dk.nyk.api.StoreApiService;
import dk.nyk.api.impl.StoreApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T15:12:04.087242442Z[GMT]")
public class StoreApiServiceFactory {
    private final static StoreApiService service = new StoreApiServiceImpl();

    public static StoreApiService getStoreApi() {
        return service;
    }
}
