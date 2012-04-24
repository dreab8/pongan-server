package org.dreborier.client.wrapper;

import com.google.gwt.core.client.JavaScriptObject;

public class Channel extends JavaScriptObject {
    protected Channel() {
    }

    public final native Socket open(SocketListener listener) /*-{
        var socket = this.open();
        socket.onopen = function(event) {
          listener.@org.dreborier.client.wrapper.SocketListener::onOpen()();
        };
        socket.onmessage = function(event) {
          listener.@org.dreborier.client.wrapper.SocketListener::onMessage(Ljava/lang/String;)(event.data);
        };
        return socket;
    }-*/;

 
}
