package dk.nyk.api;

import dk.nyk.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.util.Date;
import io.swagger.model.Error;
import java.util.Map;
import io.swagger.model.Order;

import java.util.Map;
import java.util.List;
import dk.nyk.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T15:12:04.087242442Z[GMT]")
public abstract class StoreApiService {
    public abstract Response deleteOrder(Long orderId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getInventory(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getOrderById(Long orderId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response placeOrder(Order body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response placeOrder(Long id,Long petId,Integer quantity,Date shipDate,String status,Boolean complete,SecurityContext securityContext) throws NotFoundException;
}
