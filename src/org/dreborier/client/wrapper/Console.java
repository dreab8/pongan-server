package org.dreborier.client.wrapper;

public class Console {
    public Console() {
    }

    public final native void log(String message) /*-{
        window.console.log(message);
    }-*/;
}
