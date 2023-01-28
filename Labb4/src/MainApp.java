
import javafx.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainApp extends Application {

	Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Group root = new Group();
		

		BottomPanel bPanel = new BottomPanel(500, Color.LIGHTGRAY);
		SidePanel sPanel = new SidePanel(50, 500, Color.LIGHTGRAY);
		sPanel.setLayoutX(440);

		PaintSurface pSurface = new PaintSurface(490, 500);

		root.getChildren().add(pSurface);
		root.getChildren().add(bPanel);
		root.getChildren().add(sPanel);
		
		Scene scene = new Scene(root, Color.WHITE);
		
	

		stage.setWidth(500);
		stage.setHeight(500);
		stage.setResizable(false);
		stage.setTitle("Välkommen till Ritprogammet!");
		stage.setScene(scene);
		stage.show();
		

	}

}
