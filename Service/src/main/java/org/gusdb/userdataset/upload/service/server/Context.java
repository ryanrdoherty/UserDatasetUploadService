package org.gusdb.userdataset.upload.service.server;

import org.gusdb.fgputil.server.UserAwareContext;
import org.json.JSONObject;

public class Context extends UserAwareContext {

  public Context(JSONObject config) {
    super(config);
    
    // add storage of irods config values here and maybe test connection
  }

}
