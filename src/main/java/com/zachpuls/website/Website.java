package com.zachpuls.website;

import com.zachpuls.api.view.render.BootstrapRenderer;

/**
 * Created by zpuls on 3/8/2016.
 */

public class Website {

    public static void main(String[] args) throws Exception {
        new BootstrapRenderer().renderAll();
        /*ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");

        Server server = new Server(80);
        server.setHandler(servletContextHandler);

        ServletHolder jerseyServlet = servletContextHandler.addServlet(ServletContainer.class, "*//*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", Root.class.getPackage().getName());

        server.start();
        server.join();*/
    }
}
