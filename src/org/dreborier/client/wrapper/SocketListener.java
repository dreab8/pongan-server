package org.dreborier.client.wrapper;

public interface SocketListener {
    void onOpen();
    void onMessage(String message);
}