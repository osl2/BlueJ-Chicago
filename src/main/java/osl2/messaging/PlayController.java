package osl2.messaging;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.application.Platform;

/**
 * The controller for the play functionalities.
 */
public class PlayController {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private boolean testModeActive = false;
    private boolean isProgramRunning = false;
    private long delay = 1000;
    private long tmDelay = 0;

    /**
     * Plays the changes on the datastructures.
     */
    public synchronized void play() {
        boolean oldIsProgramRunning = isProgramRunning;
        isProgramRunning = true;
        this.notifyAll();
        Platform.runLater(() ->
                pcs.firePropertyChange("isProgramRunning", oldIsProgramRunning, isProgramRunning));
    }

    /**
     * Pauses the playing of the changes.
     */
    public synchronized void pause() {
        boolean oldIsProgramRunning = isProgramRunning;
        isProgramRunning = false;
        Platform.runLater(() ->
                pcs.firePropertyChange("isProgramRunning", oldIsProgramRunning, isProgramRunning));
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
     * Plays one step inside the datastructures.
     */
    public synchronized void step() {
        if (!isProgramRunning) {
            this.notifyAll();
        }
    }

    /**
     * Sets the delay for the playing.
     *
     * @param delay
     *         The delay.
     */
    public void setProgramDelay(long delay) {
        this.delay = delay;
    }

    /**
     * Blocks the playing.
     */
    public void block() {
        if (getDelay() > 0) {
            try {
                Thread.sleep(getDelay());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (!isProgramRunning && !testModeActive) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * Adds a new PropertyChangeListener.
     *
     * @param listener
     *         The PropertyChangeListener.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public boolean getIsRunning() {
        return isProgramRunning;
    }

    public long getDelay() {
        return testModeActive ? tmDelay : delay;
    }

    public void activateTestMode(long delay) {
        testModeActive = true;
        tmDelay = delay;
    }
}
