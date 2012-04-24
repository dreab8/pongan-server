package org.dreborier.client;

import org.dreborier.client.wrapper.Channel;
import org.dreborier.client.wrapper.ChannelFactory;
import org.dreborier.client.wrapper.Console;
import org.dreborier.client.wrapper.SocketListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GoogleTvHackathon implements EntryPoint {
    private static final int KEEP_ALIVE_POLLING_TIME_IN_MILLISECONDS = 5000;
    private final PonganConsoleRegistrationServiceAsync registrationService = GWT
            .create(PonganConsoleRegistrationService.class);

    public void onModuleLoad() {
        register();
        
        pollToKeepAppEngineAlive();
    }
    
    private void  pollToKeepAppEngineAlive(){
        Timer t = new Timer() {
          public void run() {
              registrationService.keepAliveAppEngine(new AsyncCallback<Void>() {
                
                @Override
                public void onSuccess(Void result) {
                }
                
                @Override
                public void onFailure(Throwable caught) {
                }
            });
          }
        };

        t.schedule(KEEP_ALIVE_POLLING_TIME_IN_MILLISECONDS);
    }

    private void register() {

        registrationService.register(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                handleErrorMessage(caught);
            }

            @Override
            public void onSuccess(String result) {
                Channel channel = null;
                try {
                    channel = ChannelFactory.createChannel(result);
                } catch (Exception e) {
                    handleErrorMessage(e);
                }
                channel.open(new SocketListener() {
                    @Override
                    public void onMessage(String message) {
                        log(message);
                    }

                    private void log(String message) {
                        new Console().log(message);
                    }

                    @Override
                    public void onOpen() {
                        // don't know what this is about
                        // probably I should confirm to the server that
                        // I'm registered
                    }
                });
            }
        });

    }

    private void handleErrorMessage(Throwable caught) {

    }
}
