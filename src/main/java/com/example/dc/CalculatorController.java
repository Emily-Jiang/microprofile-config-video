package com.example.dc;

import java.text.DecimalFormat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 */
@Path("/calc")
@ApplicationScoped
public class CalculatorController {

    double discount = 0.1;

    @GET
    @Path("/{price}")
    public String getPrice(@PathParam("price") int price) {
        return String.valueOf(new DecimalFormat("##.##").format((price * (1 - discount))));
    }
} 
