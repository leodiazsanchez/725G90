
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BottomPanel extends HBox {

	public BottomPanel(int x, int y, Color color) {
		this.setPrefWidth(x);
		this.setLayoutY(y - 65);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
	}

}
