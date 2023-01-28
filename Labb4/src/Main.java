
import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, Color.WHITE);

		BottomPanel bPanel = new BottomPanel(500, Color.GRAY);
		SidePanel sPanel = new SidePanel(50, 500, Color.GRAY);
		sPanel.setAlignment(Pos.BASELINE_RIGHT);
		PaintSurface pSurface = new PaintSurface(490, 500);

		root.getChildren().add(pSurface);
		root.getChildren().add(bPanel);
		// root.getChildren().add(sPanel);

		stage.setWidth(500);
		stage.setHeight(500);
		stage.setTitle("Välkommen till Ritprogammet!");
		stage.setScene(scene);
		stage.show();

	}

}
