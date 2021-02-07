package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageSportmanView {
	public HomePageSportmanView() {
		//nothing
	}
	
	public void apriHPSportman(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/HomepageSportman.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
}
