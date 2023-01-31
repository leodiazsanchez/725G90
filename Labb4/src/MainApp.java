
import javafx.*;
import javafx.application.Application;
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

		int windowWidth = 600;
		int windowHeight = 600;

		int sidePanelWidth = 50;

		Group root = new Group();

		BottomPanel bPanel = new BottomPanel(windowWidth, windowHeight, Color.LIGHTGRAY);
		Button clearButton = new Button("Rensa");
		bPanel.getChildren().add(clearButton);
		SidePanel sPanel = new SidePanel(sidePanelWidth, windowHeight, Color.LIGHTGRAY);

		PaintSurface pSurface = new PaintSurface(windowWidth, windowHeight);

		pSurface.setOnMouseDragged(event -> {
			Shape shape = null;
			switch (sPanel.getSelectedShape()) {

			case CIRCLE:
				shape = new MySquare((int) event.getX(), (int) event.getY(), sPanel.getSelectedColor());
				break;
			case SQUARE:
				shape = new MyCircle((int) event.getX(), (int) event.getY(), sPanel.getSelectedColor());
				break;
			case TRIANGLE:
				shape = new MyTriangle((int) event.getX(), (int) event.getY(), sPanel.getSelectedColor());
				break;
			}
			shape.drawYourself(pSurface.getGraphicsContext2D());
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
