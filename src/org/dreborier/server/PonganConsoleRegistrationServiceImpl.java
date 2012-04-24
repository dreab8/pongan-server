package org.dreborier.server;

import org.dreborier.client.PonganConsoleRegistrationService;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PonganConsoleRegistrationServiceImpl extends RemoteServiceServlet implements PonganConsoleRegistrationService {
  

    @Override
    public String register() throws IllegalArgumentException {
        Game game = new Game();
        ChannelService channelService = ChannelServiceFactory.getChannelService();

        String channelKey = channelService.createChannel(game.getChannelKey());
        
        return channelKey;
        
    }

    @Override
    public void keepAliveAppEngine() {
        
    }
  }
