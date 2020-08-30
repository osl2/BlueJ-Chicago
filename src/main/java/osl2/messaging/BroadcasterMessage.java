package osl2.messaging;

/**
 * The Interface for a Message.
 *
 * @param <B>
 *         The receiver type.
 */
public interface BroadcasterMessage<B> {
    /**
     * Sends the message to the receiver.
     *
     * @param receiver
     *         The receiver which will get the message.
     */
    void send(B receiver);
}
