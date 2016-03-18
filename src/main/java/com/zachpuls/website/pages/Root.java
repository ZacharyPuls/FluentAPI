package com.zachpuls.website.pages;

import j2html.TagCreator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static j2html.TagCreator.*;

/**
 * Created by zpuls on 3/8/2016.
 */

@Path("/")
public class Root {

    @GET
    @Produces("text/html")
    public String getIndex() {
        return body().with(
                div().withClass("row").with(
                    div().withClass("col-md-4").with(
                        div().withClass("card blue-grey darken-1").with(
                            div().withClass("card-content white-text").with(
                                span().withClass("card-title").withContent("Test Title"),
                                p().withContent("This is a test card.")
                            )
                        )
                    )
                )
        ).render();
    }

}
