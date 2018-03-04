package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainController implements Initializable {

	@FXML
	private Button openFileButton;

	@FXML
	private Label openFileInfoLabel;

	@FXML
	private ProgressBar progresBar;

	@FXML
	private Label songName;

	@FXML
	private Label songTime;

	@FXML
	private Button stopButton;

	@FXML
	private Button pauseButton;

	@FXML
	private Button playButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		setOpenFileButtonClickEvent();
		
	}

	private void setOpenFileButtonClickEvent() {
		getOpenFileButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Witaj swiecie");

			}
		});
	}

	private Button getOpenFileButton() {
		return openFileButton;
	}

	private void setOpenFileButton(Button openFileButton) {
		this.openFileButton = openFileButton;
	}

	private Label getOpenFileInfoLabel() {
		return openFileInfoLabel;
	}

	private void setOpenFileInfoLabel(Label openFileInfoLabel) {
		this.openFileInfoLabel = openFileInfoLabel;
	}

	private ProgressBar getProgresBar() {
		return progresBar;
	}

	private void setProgresBar(ProgressBar progresBar) {
		this.progresBar = progresBar;
	}

	private Label getSongName() {
		return songName;
	}

	private void setSongName(Label songName) {
		this.songName = songName;
	}

	private Label getSongTime() {
		return songTime;
	}

	private void setSongTime(Label songTime) {
		this.songTime = songTime;
	}

	private Button getStopButton() {
		return stopButton;
	}

	private void setStopButton(Button stopButton) {
		this.stopButton = stopButton;
	}

	private Button getPauseButton() {
		return pauseButton;
	}

	private void setPauseButton(Button pauseButton) {
		this.pauseButton = pauseButton;
	}

	private Button getPlayButton() {
		return playButton;
	}

	private void setPlayButton(Button playButton) {
		this.playButton = playButton;
	}

}
