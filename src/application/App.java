package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/view/MainPane.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("MP3 Player");
		stage.show();

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				Platform.exit();
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception {

		super.stop();
	}

}
