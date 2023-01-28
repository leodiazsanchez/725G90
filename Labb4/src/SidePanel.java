
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SidePanel extends VBox {
	private ColorButton[] cButtons;
	private ShapeButton[] sButtons;

	public SidePanel(int x, int y, Color color) {
		this.setPrefWidth(x);
		this.setPrefHeight(y);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));

		Label label = new Label("Färg");

		label.setTextFill(Color.BLACK);
		this.getChildren().add(label);
	}
}
