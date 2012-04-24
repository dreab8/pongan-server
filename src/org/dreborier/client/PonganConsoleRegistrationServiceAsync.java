package org.dreborier.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface PonganConsoleRegistrationServiceAsync {

    void register(AsyncCallback<String> callback);

    void keepAliveAppEngine(AsyncCallback<Void> callback);

}
