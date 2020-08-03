package osl2.view.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.Evanston;

/**
 * The Playspace is the space in the View were the user can play the changes in his Datastructures.
 */
public class PlaySpace extends Pane {

    private Button playAutoButton;
    private Button playStepButton;
    private Slider playSpeedSlider;
    private VBox splitLayout;
    private HBox buttonBox;
    private HBox sliderBox;

    /**
     * Sets up the Playspace and all its components.
     */
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

    /**
     * This method adds a listener, so that when the size of the pane changes the layout gets resized with it.
     */
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

    /**
     * This method adds the VBox where later the Button Space and the Speedslider Space will be in.
     */
    private void setSplitLayout() {
        splitLayout = new VBox();
        splitLayout.setPrefSize(this.getWidth(), this.getHeight());
        this.getChildren().add(splitLayout);
        splitLayout.resize(this.getWidth(), this.getHeight());
    }

    /**
     * This Method sets the HBox where the Play and Step-By-Step button will be added.
     */
    private void setButtonBox() {
        buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(this.getWidth() - this.getWidth() / 1.5);
        splitLayout.getChildren().add(buttonBox);
    }

    /**
     * This Method sets the HBox where the Speedslider will be added.
     */
    private void setSliderBox() {
        sliderBox = new HBox();
        splitLayout.getChildren().add(sliderBox);
    }

    /**
     * This method sets the Play Button, adds it to the Buttonspace and sets his action, when clicked.
     */
    private void setPlayButton() {
        playAutoButton = new Button("Play");
        playAutoButton.setOnAction((event) -> Evanston.getPlayController().toggle());
        playAutoButton.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(playAutoButton);
    }

    /**
     * This method sets the Step-by-Step Button, adds it to the Buttonspace and sets his action, when clicked.
     */
    private void setStepbystepButton() {
        playStepButton = new Button("Step");
        playStepButton.setOnAction((event) -> Evanston.getPlayController().step());
        playStepButton.setAlignment(Pos.CENTER_LEFT);
        buttonBox.getChildren().add(playStepButton);
    }

    /**
     * This method sets the slider for the speed, adds it to the Sliderspace and sets it's action, when slided.
     */
    private void setSlider() {
        final int MAX = 1000;

        playSpeedSlider = new Slider();
        playSpeedSlider.setMin(0);
        playSpeedSlider.setMax(1);
        playSpeedSlider.setValue(0);
        playSpeedSlider.setShowTickLabels(false);
        playSpeedSlider.setPrefWidth(this.getWidth());
        playSpeedSlider.valueProperty().addListener((ov, oldVal, newVal) -> Evanston.getPlayController().setProgramDelay((long) (MAX - Math.pow((double) oldVal, 1d/8) * (MAX - 1))));
        sliderBox.getChildren().add(playSpeedSlider);
    }

    /**
     * This method sets the style of the playspace.
     */
    private void setColour() {
        this.getStyleClass().add("playspace");
    }
}
