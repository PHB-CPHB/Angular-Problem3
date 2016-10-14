/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import facade.CarFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import jsonconveter.JSONConverter;

/**
 * REST Web Service
 *
 * @author philliphbrink
 */
@Path("car")
public class CarRest {

    @Context
    private UriInfo context;
    
    private final CarFacade facade = new CarFacade();
    /**
     * Creates a new instance of CarRest
     */
    public CarRest() {
    }

    /**
     * Retrieves representation of an instance of rest.CarRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return JSONConverter.getJSONFromObject(facade.getCars());
    }

    /**
     * PUT method for updating or creating an instance of CarRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
