package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/view/MainPane.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("MP3 Player");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}