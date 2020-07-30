package osl2.evanston.messaging;

public interface BroadcasterMessage<B> {
    void send(B receiver);
}
