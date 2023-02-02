
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SidePanel extends VBox {

	private Color[] colors = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
			Color.WHITE, Color.ORANGE };
	
	private Shape[] shapes = {new MyCircle(0,0, Color.BLACK), new MySquare(0,0, Color.BLACK), new MyTriangle(0,0, Color.BLACK)};

	public SidePanel(int x, int y, Color color, Model model) {
		this.setPrefWidth(x);
		this.setPrefHeight(y);
		this.setLayoutX(y - x - 15);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setSpacing(10);
		this.setAlignment(Pos.TOP_CENTER);
		
		Label colorLabel = new Label("Färg");
		colorLabel.setTextFill(Color.BLACK);
		this.getChildren().add(colorLabel);

		for (Color c : colors) {
			this.getChildren().add(new ColorButton(c, model));
		}

		Label shapeLabel = new Label("Former");
		shapeLabel.setTextFill(Color.BLACK);
		this.getChildren().add(shapeLabel);
		
		for (Shape s : shapes) {
			this.getChildren().add(new ShapeButton(s, model));
		}

	}

}
