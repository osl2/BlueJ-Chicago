package osl2.view.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.Evanston;


public class PlaySpace extends Pane {

    private Button playAutoButton;
    private Button playStepButton;
    private Slider playSpeedSlider;
    private VBox splitLayout;
    private HBox buttonBox;
    private HBox sliderBox;

    public PlaySpace() {
        setSplitLayout();
        setButtonBox();
        setSliderBox();
        setStepbystepButton();
        setPlayButton();
        setSlider();
        setVBoxListener();
        setColour();
    }

    private void setVBoxListener() {
        this.heightProperty().addListener(e -> {
            splitLayout.setPrefSize(this.getWidth(), this.getHeight());
            buttonBox.setPrefSize(this.getWidth(), this.getHeight() / 2);
            sliderBox.setPrefSize(this.getWidth(), this.getHeight() / 2);
        });
        this.widthProperty().addListener(e -> {
            splitLayout.setPrefSize(this.getWidth(), this.getHeight());
            buttonBox.setPrefSize(this.getWidth(), this.getHeight() / 2);
            buttonBox.setSpacing(this.getWidth() - this.getWidth() / 1.5);
            sliderBox.setPrefSize(this.getWidth(), this.getHeight() / 2);
            playSpeedSlider.setPrefWidth(this.getWidth());
        });
    }

    private void setSplitLayout() {
        splitLayout = new VBox();
        splitLayout.setPrefSize(this.getWidth(), this.getHeight());
        this.getChildren().add(splitLayout);
        splitLayout.resize(this.getWidth(), this.getHeight());
    }

    private void setButtonBox() {
        buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(this.getWidth() - this.getWidth() / 1.5);
        splitLayout.getChildren().add(buttonBox);
    }

    private void setSliderBox() {
        sliderBox = new HBox();
        splitLayout.getChildren().add(sliderBox);
    }

    private void setPlayButton() {
        playAutoButton = new Button("Play");
        playAutoButton.setOnAction((event) -> Evanston.getPlayController().toggle());
        playAutoButton.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(playAutoButton);
    }

    private void setStepbystepButton() {
        playStepButton = new Button("Step");
        playStepButton.setOnAction((event) -> Evanston.getPlayController().step());
        playStepButton.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().add(playStepButton);
    }

    private void setSlider() {
        playSpeedSlider = new Slider();
        playSpeedSlider.setMin(1);
        playSpeedSlider.setMax(Math.sqrt(1000));
        playSpeedSlider.setValue(1);
        playSpeedSlider.setShowTickLabels(false);
        playSpeedSlider.setPrefWidth(this.getWidth());
        playSpeedSlider.valueProperty().addListener((ov, oldVal, newVal) -> Evanston.getPlayController().setProgramDelay((long) Math.pow((double) newVal, 2)));
        sliderBox.getChildren().add(playSpeedSlider);
    }

    private void setColour() {
        this.getStyleClass().add("playspace");
    }
}
