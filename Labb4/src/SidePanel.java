
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SidePanel extends VBox {
	private ColorButton[] cButtons = new ColorButton[8];
	private ShapeButton[] sButtons = new ShapeButton[3];

	public SidePanel(int x, int y, Color color) {
		this.setPrefWidth(x);
		this.setPrefHeight(y);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));

		this.setAlignment(Pos.TOP_CENTER);
		
		Label label = new Label("Färg");
		
		

		label.setTextFill(Color.BLACK);
		this.getChildren().add(label);
	}
}
