package osl2.messaging;

import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The controller for the play functionalities.
 */
public class PlayController {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private boolean isProgramRunning = false;
    private long delay = 1000;

    /**
     * Plays the changes on the datastructures.
     */
    public synchronized void play() {
        boolean oldIsProgramRunning = isProgramRunning;
        isProgramRunning = true;
        this.notifyAll();
        Platform.runLater(() -> pcs.firePropertyChange("isProgramRunning", oldIsProgramRunning, isProgramRunning));
    }

    /**
     * Pauses the playing of the changes.
     */
    public synchronized void pause() {
        boolean oldIsProgramRunning = isProgramRunning;
        isProgramRunning = false;
        Platform.runLater(() -> pcs.firePropertyChange("isProgramRunning", oldIsProgramRunning, isProgramRunning));
    }

    /**
     * Toggles between playing and paused.
     */
    public void toggle() {
        if (isProgramRunning) {
            pause();
        } else {
            play();
        }
    }

    /**
     * Playes one step inside the datastructures.
     */
    public synchronized void step() {
        if (!isProgramRunning) this.notify();
    }

    /**
     * Sets the delay for the playing.
     *
     * @param delay The delay.
     */
    public void setProgramDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Blocks the playing.
     */
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
