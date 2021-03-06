package osl2.messaging;

import javafx.application.Platform;
import osl2.Evanston;

/**
 * A broadcaster which sends messages to one client.
 *
 * @param <B>
 *         The client's type.
 */
public class Broadcaster<B> {
    private final B client;

    /**
     * Creates a new broadcaster for one client.
     *
     * @param client
     *         The client for this Broadcaster.
     */
    public Broadcaster(B client) {
        this.client = client;
    }

    /**
     * Returns the client to this broadcaster.
     *
     * @return The client.
     */
    public B getClient() {
        return client;
    }

    /**
     * Sends a message to the client.
     *
     * @param message
     *         The message for the client.
     */
    public void send(BroadcasterMessage<B> message) {
        Platform.runLater(() -> message.send(client));  // Run in other thread
    }

    /**
     * Sends a message to the client with a delay. Delay accordingly to the speed in the PlayController.
     *
     * @param message
     *         The message for the client.
     */
    public void sendWithDelay(BroadcasterMessage<B> message) {
        Evanston.getPlayController().block();
        send(message);
    }

    /**
     * Sends a message with a pause and a block.
     *
     * @param message
     *         The message to be sent
     */
    public void sendWithPauseBlock(BroadcasterMessage<B> message) {
        Evanston.getPlayController().pause();
        send(message);
        Evanston.getPlayController().block();
    }
}
