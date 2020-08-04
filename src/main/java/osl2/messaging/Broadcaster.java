package osl2.messaging;

import javafx.application.Platform;
import osl2.Evanston;

public class Broadcaster<B> {
    private final B client;

    public Broadcaster(B client) {
        this.client = client;
    }

    public B getClient() {
        return client;
    }

    public void send(BroadcasterMessage<B> message) {
        Platform.runLater(() -> message.send(client));  // Run in other thread
    }

    public void sendWithDelay(BroadcasterMessage<B> message) {
        send(message);
        Evanston.getPlayController().block();
    }
}
