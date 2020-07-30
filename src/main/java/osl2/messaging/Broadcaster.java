package osl2.messaging;

import javafx.application.Platform;

public class Broadcaster<B> {
    private final B client;

    public Broadcaster(B client) {
        this.client = client;
    }

    public void send(BroadcasterMessage<B> message) {
        Platform.runLater(() -> message.send(client));  // Run in other thread
    }
}
