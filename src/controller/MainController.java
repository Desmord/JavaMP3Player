package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

public class MainController implements Initializable {

	private File music = null;
	private Media hit = null;
	private MediaPlayer mediaPlayer = null;

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
		setPlayButtonClickEvent();
		setPauseButtonClickEvent();
		setStopButtonClickEvent();

	}

	private void setOpenFileButtonClickEvent() {
		this.openFileButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				try {

					music = getFile();

					if (isFileNotNull()) {
						setOpenFileInfoLabelText("Nie otworzono ¿adnego pliku.");

					} else if (isFileMP3File()) {
						setOpenFileInfoLabelText("Podany plik nie jest plikiem foramtu mp3.");

					} else {
						clearOpenFileInfoLabelText();

						setMusic();

					}
				} catch (Exception e) {
					setOpenFileInfoLabelText("Wyst¹pi³ b³¹d przy próbie wczytania pliku.");
				}
			}
		});
	}

	private void setMusic() {

		this.hit = new Media(this.music.toURI().toString());
		this.mediaPlayer = new MediaPlayer(hit);

		this.mediaPlayer.setOnReady(new Runnable() {

			@Override
			public void run() {

				setSongTimeLabelText(secondsToMinutes(mediaPlayer.getCurrentTime().toSeconds()) + " / "
						+ secondsToMinutes(hit.getDuration().toSeconds()));

				setProgresBarProgres(0.0);

			}
		});

		setSongNameLabelText(this.music.getName());

	}

	private String secondsToMinutes(Double seconds) {

		Double minutes = 0.0;

		minutes = minutes + (seconds.intValue() / 60);
		int rest = seconds.intValue() % 60;

		return minutes.intValue() + " : " + rest;

	}

	private File getFile() {

		FileChooser chooser = new FileChooser();
		chooser.setTitle("Wybierz utwór");
		File selectedFile = chooser.showOpenDialog(null);

		return selectedFile;

	}

	private boolean isFileNotNull() {

		if (this.music == null) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isFileMP3File() {

		Pattern pattern = Pattern.compile("(mp3)$");
		Matcher matcher = pattern.matcher(this.music.getName());

		if (matcher.find()) {
			return false;

		} else {
			return true;

		}
	}

	private void setPlayButtonClickEvent() {

		this.playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				if (mediaPlayer == null) {
					setOpenFileInfoLabelText("Nie wczytano ¿adnego utworu.");
				} else {
					clearOpenFileInfoLabelText();
					mediaPlayer.play();
				}

			}
		});

	}

	private void setPauseButtonClickEvent() {
		
		this.pauseButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				if (mediaPlayer == null) {
					setOpenFileInfoLabelText("Nie wczytano ¿adnego utworu.");
				} else {
					clearOpenFileInfoLabelText();
					mediaPlayer.pause();
				}

			}
		});
		
	}

	private void setStopButtonClickEvent() {
		
		this.stopButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				if (mediaPlayer == null) {
					setOpenFileInfoLabelText("Nie wczytano ¿adnego utworu.");
				} else {
					clearOpenFileInfoLabelText();
					mediaPlayer.stop();
				}

			}
		});
		
	}
	
	
	// this.mediaPlayer.getCurrentTime();
	// this.mediaPlayer.getStopTime();
	// System.out.println(this.mediaPlayer.getTotalDuration());
	// System.out.println(this.mediaPlayer.getCurrentTime());
	// mediaPlayer.play();

	private void setProgresBarProgres(double percent) {
		this.progresBar.setProgress(percent);
	}

	private void setSongNameLabelText(String text) {
		this.songName.setText(text);
	}

	private void clearSongNameLabelText() {
		this.songName.setText("");
	}

	private void setSongTimeLabelText(String text) {
		this.songTime.setText(text);
	}

	private void clearSongTimeLabelText() {
		this.songTime.setText("");
	}

	private void setOpenFileInfoLabelText(String text) {
		this.openFileInfoLabel.setText(text);
	}

	private void clearOpenFileInfoLabelText() {
		this.openFileInfoLabel.setText("");
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
