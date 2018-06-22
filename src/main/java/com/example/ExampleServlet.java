package com.example;

import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.GET;
import org.jooby.mvc.Path;
import org.jooby.mvc.Produces;

import javax.inject.Singleton;

@Singleton
@Path("/example")
public class ExampleServlet {

    @GET
    @Path("/")
    @Produces("json")
    public Result example() {
        ExampleDomain exampleDomain = new ExampleDomain("foo", "bar", 1);
        return Results.json(exampleDomain);
    }

}
