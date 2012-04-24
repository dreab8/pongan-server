package org.dreborier.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("register")
public interface PonganConsoleRegistrationService extends RemoteService {
    String register() throws IllegalArgumentException;
    
    void keepAliveAppEngine();
    
}
