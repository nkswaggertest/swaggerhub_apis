package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PetApiService;
import io.swagger.api.factories.PetApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.Category;
import io.swagger.model.Error;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Pet;
import io.swagger.model.Tag;

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


@Path("/pet")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T14:14:21.170511440Z[GMT]")
public class PetApi  {
   private final PetApiService delegate;

   public PetApi(@Context ServletConfig servletContext) {
      PetApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PetApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PetApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PetApiServiceFactory.getPetApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Add a new pet to the store.", description = "Add a new pet to the store.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Validation exception"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response addPet(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new pet in the store" ,required=true) Pet body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addPet(body,securityContext);
    }
    @DELETE
    @Path("/{petId}")
    
    @Produces({ "application/json" })
    @Operation(summary = "Deletes a pet.", description = "Delete a pet.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pet deleted"),
        
        @ApiResponse(responseCode = "400", description = "Invalid pet value"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response deletePet(@Parameter(in = ParameterIn.PATH, description = "Pet id to delete",required=true) @PathParam("petId") Long petId,
@Parameter(in = ParameterIn.HEADER, description = "" )@HeaderParam("api_key") String apiKey
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deletePet(petId,apiKey,securityContext);
    }
    @GET
    @Path("/findByStatus")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Finds Pets by status.", description = "Multiple status values can be provided with comma separated strings.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),
        
        @ApiResponse(responseCode = "400", description = "Invalid status value"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response findPetsByStatus(@Parameter(in = ParameterIn.QUERY, description = "Status values that need to be considered for filter", schema=@Schema(allowableValues={ "available", "pending", "sold" })
) @DefaultValue("available") @QueryParam("status") String status,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findPetsByStatus(status,securityContext);
    }
    @GET
    @Path("/findByTags")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Finds Pets by tags.", description = "Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),
        
        @ApiResponse(responseCode = "400", description = "Invalid tag value"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response findPetsByTags(@Parameter(in = ParameterIn.QUERY, description = "Tags to filter by") @QueryParam("tags") List<String> tags,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findPetsByTags(tags,securityContext);
    }
    @GET
    @Path("/{petId}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Find pet by ID.", description = "Returns a single pet.", security = {
        @SecurityRequirement(name = "api_key"),
@SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "404", description = "Pet not found"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response getPetById(@Parameter(in = ParameterIn.PATH, description = "ID of pet to return",required=true) @PathParam("petId") Long petId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPetById(petId,securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Update an existing pet.", description = "Update an existing pet by Id.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "404", description = "Pet not found"),
        
        @ApiResponse(responseCode = "422", description = "Validation exception"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response updatePet(@Parameter(in = ParameterIn.DEFAULT, description = "Update an existent pet in the store" ,required=true) Pet body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePet(body,securityContext);
    }
    @POST
    @Path("/{petId}")
    
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "Updates a pet in the store with form data.", description = "Updates a pet resource based on the form data.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response updatePetWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of pet that needs to be updated",required=true) @PathParam("petId") Long petId,@Parameter(in = ParameterIn.QUERY, description = "Name of pet that needs to be updated") @QueryParam("name") String name,@Parameter(in = ParameterIn.QUERY, description = "Status of pet that needs to be updated") @QueryParam("status") String status,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updatePetWithForm(petId,name,status,securityContext);
    }
    @POST
    @Path("/{petId}/uploadImage")
    @Consumes({ "application/octet-stream" })
    @Produces({ "application/json" })
    @Operation(summary = "Uploads an image.", description = "Upload image of the pet.", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
"read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "No file uploaded"),
        
        @ApiResponse(responseCode = "404", description = "Pet not found"),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    public Response uploadFile(@Parameter(in = ParameterIn.PATH, description = "ID of pet to update",required=true) @PathParam("petId") Long petId,@Parameter(in = ParameterIn.DEFAULT, description = "" ) Object body
,@Parameter(in = ParameterIn.QUERY, description = "Additional Metadata") @QueryParam("additionalMetadata") String additionalMetadata,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.uploadFile(petId,body,additionalMetadata,securityContext);
    }
}
