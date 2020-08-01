package osl2.messaging;

public class PlayController {
    private boolean isProgramRunning = false;
    private long delay = 1;

    public synchronized void play() {
        isProgramRunning = true;
        this.notifyAll();
    }

    public synchronized void pause() {
        isProgramRunning = false;
    }

    public void toggle() {
        if (isProgramRunning) {
            pause();
        } else {
            play();
        }
    }

    public synchronized void step() {
        if (!isProgramRunning) this.notify();
    }

    public void setProgramDelay(long delay) {
        this.delay = delay;
    }

    public void block() {
        if (delay > 0) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }

        if (!isProgramRunning) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
