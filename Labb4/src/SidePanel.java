
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

	private Color selectedColor = Color.BLACK;
	private ShapeNames selectedShape = ShapeNames.CIRCLE;

	private Color[] colors = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
			Color.WHITE, Color.ORANGE };

	private ShapeNames[] shapes = { ShapeNames.CIRCLE, ShapeNames.SQUARE, ShapeNames.TRIANGLE };

	public SidePanel(int x, int y, Color color) {
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
			ColorButton b = new ColorButton(c);
			b.setAlignment(Pos.TOP_CENTER);
			this.getChildren().add(b);
		}

		Label shapeLabel = new Label("Former");

		shapeLabel.setTextFill(Color.BLACK);
		shapeLabel.setAlignment(Pos.TOP_CENTER);
		this.getChildren().add(shapeLabel);

		for (ShapeNames s : shapes) {
			ShapeButton b = new ShapeButton(s);
			b.setAlignment(Pos.TOP_CENTER);
			this.getChildren().add(b);
		}

	}

	public Color getSelectedColor() {
		return selectedColor;
	}

	public ShapeNames getSelectedShape() {
		return selectedShape;
	}

	private class ColorButton extends Button {

		private ColorButton(Color color) {
			this.setPrefWidth(35);
			this.setPrefHeight(35);
			this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), null)));
			this.setOnMouseClicked(event -> {
				Color borderColor  = (color.equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
				this.setBorder(new Border(new BorderStroke(borderColor, BorderStrokeStyle.SOLID, new CornerRadii(8),
						new BorderWidths(2))));
				selectedColor = color;
			});
			

		}

	}

	private class ShapeButton extends Button {

		private ShapeButton(ShapeNames shape) {
			this.setPrefWidth(25);
			this.setPrefHeight(25);
			Canvas canvas = new Canvas(this.getPrefWidth(), this.getPrefHeight());
			GraphicsContext gc = canvas.getGraphicsContext2D();
			shape.shape.drawYourself(gc, 0, 0, Color.BLACK);
			this.setGraphic(canvas);

			this.setOnMouseClicked(event -> {
				this.setBorder(new Border(
						new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
				selectedShape = shape;
				event.consume();
			});

		}

	}
}
