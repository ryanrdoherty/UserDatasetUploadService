package org.gusdb.userdataset.upload.service;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.Request;
import org.gusdb.fgputil.accountdb.UserProfile;
import org.gusdb.fgputil.server.AuthenticationFilter;

@Path("/")
public class Service {

  @Inject
  private Provider<Request> _request;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response checkUser() {
    UserProfile user = AuthenticationFilter.getUserProfile(_request.get());
    return Response.ok("Found authenticated user with ID: " + user.getUserId()).build();
  }
}