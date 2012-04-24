package org.dreborier.server;

import org.dreborier.shared.CodeMoveTeamMatcher;
import org.dreborier.shared.CodeMoveTeamMatcher.Move;
import org.dreborier.shared.CodeMoveTeamMatcher.Team;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;

public class Game {

    
    private static final String CHANNEL_KEY = "pongan_channel_key";
    private Key key;

    public Key getKey() {
        return key;
    }
    
    public void setKey(Key key){
        this.key = key;
    }

    public String getChannelKey() {
        return CHANNEL_KEY;
    }
    
    public void sendUpdateToConsole(Team team, Move move){
        try{
        ChannelService channelService = ChannelServiceFactory.getChannelService();
        String channelKey = getChannelKey();
        
        channelService.sendMessage(new ChannelMessage(channelKey, CodeMoveTeamMatcher.getCodeOfTheMove(team,move)));
        }catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}
