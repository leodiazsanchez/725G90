import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BottomPanel extends HBox {

	public BottomPanel(int x, Color color) {
		this.setPrefWidth(x);
		this.getChildren().add(new ClearButton());
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
	}

	private class ClearButton extends Button {

		private ClearButton() {
			super("Rensa");
			this.setOnMouseClicked(handler);
		}

		private EventHandler<InputEvent> handler = new EventHandler<InputEvent>() {
			public void handle(InputEvent event) {
				System.out.println("Clear");
				event.consume();
			}
		};

	}
}
