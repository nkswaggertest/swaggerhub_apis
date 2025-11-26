package dk.nyk.api;

import dk.nyk.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Error;
import io.swagger.model.User;

import java.util.Map;
import java.util.List;
import dk.nyk.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2025-11-26T15:12:04.087242442Z[GMT]")
public abstract class UserApiService {
    public abstract Response createUser(User body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createUser(Long id,String username,String firstName,String lastName,String email,String password,String phone,Integer userStatus,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createUsersWithListInput(List<User> body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getUserByName(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response loginUser( String username, String password,SecurityContext securityContext) throws NotFoundException;
    public abstract Response logoutUser(SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(String username,User body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(String username,Long id,String username2,String firstName,String lastName,String email,String password,String phone,Integer userStatus,SecurityContext securityContext) throws NotFoundException;
}
