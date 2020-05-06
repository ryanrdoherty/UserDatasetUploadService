package org.gusdb.userdataset.upload.service.server;

import java.net.URI;

import org.glassfish.jersey.server.ResourceConfig;
import org.gusdb.fgputil.server.AuthenticationFilter;
import org.gusdb.fgputil.server.LoggingExceptionMapper;
import org.gusdb.fgputil.server.RESTServer;
import org.gusdb.fgputil.web.ApplicationContext;
import org.gusdb.userdataset.upload.service.Service;
import org.json.JSONObject;

public class Server extends RESTServer {

  public static void main(String[] args) {
    new Server(args).start();
  }

  private Server(String[] args) {
    super(args);
  }

  @Override
  public ResourceConfig getResourceConfig() {
    // create a Jersey resource config containing our service and provider classes
    return new ResourceConfig().registerClasses(
        AuthenticationFilter.class,
        LoggingExceptionMapper.class,
        Service.class
    );
  }

  @Override
  protected ApplicationContext createApplicationContext(URI serviceUri, JSONObject config) {
    return new Context(config);
  }

  public static Context getContext() {
    return (Context)getApplicationContext();
  }
}
