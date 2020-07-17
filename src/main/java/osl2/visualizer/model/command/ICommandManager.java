package osl2.visualizer.model.command;

public interface ICommandManager {

    public void addCommand(ICommand command);

    public void playStep();

    public void startAutoPlay();

    public void stopAutoPlay();

}
