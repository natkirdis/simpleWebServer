package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

public class Main {

  public static void main(String[] args) throws Exception {

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.addServlet(new ServletHolder(new AllRequestsServlet("test1")), "/test1");
    context.addServlet(new ServletHolder(new AllRequestsServlet("test2")), "/test2");

    Server server = new Server(8877);
    server.setHandler(context);

    server.start();
    server.join();
  }
}
