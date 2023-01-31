
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		int windowWidth = 800;
		int windowHeight = 800;

		int sidePanelWidth = 50;

		Group root = new Group();

		BottomPanel bPanel = new BottomPanel(windowWidth, windowHeight, Color.LIGHTGRAY);
		Button clearButton = new Button("Rensa");
		bPanel.getChildren().add(clearButton);
		SidePanel sPanel = new SidePanel(sidePanelWidth, windowHeight, Color.LIGHTGRAY);

		PaintSurface pSurface = new PaintSurface(windowWidth, windowHeight);

		pSurface.setOnMouseDragged(event -> {
			int x = (int) event.getX();
			int y = (int) event.getY();
			Color color = sPanel.getSelectedColor();
			sPanel.getSelectedShape().shape.drawYourself(pSurface.getGraphicsContext2D(), x, y, color);
		});

		clearButton.setOnMouseClicked(event -> {
			pSurface.getGraphicsContext2D().clearRect(0, 0, windowWidth, windowHeight);
		});

		root.getChildren().add(pSurface);
		root.getChildren().add(bPanel);
		root.getChildren().add(sPanel);

		Scene scene = new Scene(root, Color.WHITE);

		stage.setWidth(windowWidth);
		stage.setHeight(windowWidth);
		stage.setResizable(false);
		stage.setTitle("Välkommen till Ritprogammet!");
		stage.setScene(scene);
		stage.show();

	}

}
