package osl2.visualizer.gui;

import javafx.scene.layout.Pane;

public class PlaySpace extends Pane {

    private Button playButton;
    private Button stepbystepButton;
    private Slider playSpeedSlider;
    private VBox splitLayout;
    private HBox buttonBox;
    private HBox sliderBox;

    public PlaySpace(){
        setSplitLayout();
        setButtonBox();
        setSliderBox();
        setStepbystepButton();
        setPlayButton();
        setSlider();
        setVBoxListener();
    }

    private void setVBoxListener(){
        this.heightProperty().addListener(e -> {
            splitLayout.setPrefSize(this.getWidth(), this.getHeight());
            buttonBox.setPrefSize(this.getWidth(), this.getHeight()/2);
            sliderBox.setPrefSize(this.getWidth(), this.getHeight()/2);
        });
        this.widthProperty().addListener(e -> {
            splitLayout.setPrefSize(this.getWidth(), this.getHeight());
            buttonBox.setPrefSize(this.getWidth(), this.getHeight()/2);
            buttonBox.setSpacing(this.getWidth() - this.getWidth()/1.5);
            sliderBox.setPrefSize(this.getWidth(), this.getHeight()/2);
            playSpeedSlider.setPrefWidth(this.getWidth());
        });
    }
    private void setSplitLayout(){
        splitLayout = new VBox();
        splitLayout.setPrefSize(this.getWidth(), this.getHeight());
        this.getChildren().add(splitLayout);
        splitLayout.resize(this.getWidth(), this.getHeight());
    }

    private void setButtonBox(){
        buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(this.getWidth() - this.getWidth()/1.5);
        splitLayout.getChildren().add(buttonBox);
    }

    private void setSliderBox(){
        sliderBox = new HBox();
        splitLayout.getChildren().add(sliderBox);
    }


    private void setPlayButton(){
        playButton = new Button("Play");
        playButton.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(playButton);
    }

    private void setStepbystepButton(){
        stepbystepButton = new Button("Step");
        stepbystepButton.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().add(stepbystepButton);
    }
    private void setSlider(){
        playSpeedSlider = new Slider();
        playSpeedSlider.setMin(0);
        playSpeedSlider.setMax(100);
        playSpeedSlider.setValue(50);
        playSpeedSlider.setShowTickLabels(true);
        playSpeedSlider.setPrefWidth(this.getWidth());
        sliderBox.getChildren().add(playSpeedSlider);
    }

    public double getSliderSpeed(){
        return playSpeedSlider.getValue();
    }
}
