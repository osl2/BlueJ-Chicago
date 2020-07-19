package osl2.visualizer.model.command;

public interface ICommandManager {

    void addCommand(ICommand command);

    void playStep();

    void startAutoPlay();

    void stopAutoPlay();

    /**
     * Set the playspeed.
     *
     * @param playspeed - the playspeed to be set
     */
    void setPlayspeed(int playspeed);

}
