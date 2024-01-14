package com.pkg;
/* Author Sandipan Kundu , dated - 14/01/2024*/
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
       Properties properties = (Properties) System.getProperties();
        String propertyValue = properties.getProperty("ROOT");
        return "Value from properties file -"+propertyValue;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public Response greetPerson(Person person) {
        if (person.getName().equalsIgnoreCase("John") ) {
            String greeting = "Hello, " + person.getName() + "!";
            return Response.status(Response.Status.OK).entity(greeting).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input name").build();
        }
    }
}
