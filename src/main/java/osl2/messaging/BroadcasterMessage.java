package osl2.messaging;

public interface BroadcasterMessage<B> {
    void send(B receiver);
}
