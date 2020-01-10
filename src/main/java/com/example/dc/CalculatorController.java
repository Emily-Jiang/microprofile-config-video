package com.example.dc;

import java.text.DecimalFormat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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

    @Inject @ConfigProperty(name="discount", defaultValue = "0.2") double discount;
    @GET
    @Path("/{price}")
    public String getPrice(@PathParam("price") int price) {
        return "Original Price: " + price + "   You Pay: " + String.valueOf(new DecimalFormat("##.##").format((price * (1 - discount))));
    }
} 
