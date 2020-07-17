package osl2.visualizer.model.command;

import java.util.LinkedList;

public class CommandManager implements ICommandManager {

    private int playspeed;
    private LinkedList<ICommand> commandList;
    private boolean isRunning = false;

    public void setPlayspeed(int playspeed){
        this.playspeed = playspeed;
    }

    @Override
    public void addCommand(ICommand command) {
        commandList.addLast(command);
    }

    @Override
    public void playStep() {
        commandList.getFirst().execute();
        commandList.removeFirst();
    }

    private class RunThread implements Runnable{

        @Override
        public void run() {
            while(isRunning){
                playStep();
                try {
                    Thread.sleep(playspeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void startAutoPlay() {
        isRunning = true;
        Thread autoPlayThread = new Thread(new RunThread());
        autoPlayThread.start();
    }

    @Override
    public void stopAutoPlay() {
        isRunning = false;
    }
}
