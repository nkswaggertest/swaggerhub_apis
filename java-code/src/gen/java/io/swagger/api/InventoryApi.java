package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.InventoryApiService;
import io.swagger.api.factories.InventoryApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.InventoryItem;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/inventory")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T15:16:15.468392484Z[GMT]")
public class InventoryApi  {
   private final InventoryApiService delegate;

   public InventoryApi(@Context ServletConfig servletContext) {
      InventoryApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("InventoryApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (InventoryApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = InventoryApiServiceFactory.getInventoryApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "adds an inventory item", description = "Adds an item to the system", tags={ "admins" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "item created"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "an existing item already exists") })
    public Response addInventory(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add" ) InventoryItem body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addInventory(body,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @Operation(summary = "searches inventory", description = "By passing in the appropriate options, you can search for available inventory in the system ", tags={ "developers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InventoryItem.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    public Response searchInventory(@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory") @QueryParam("searchString") String searchString,@Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema=@Schema(allowableValues={ "0" })
) @QueryParam("skip") Integer skip,@Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema=@Schema(allowableValues={ "0", "50" }, maximum="50")
) @QueryParam("limit") Integer limit,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchInventory(searchString,skip,limit,securityContext);
    }
}
