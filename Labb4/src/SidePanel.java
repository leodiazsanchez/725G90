
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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

		private Color color;

		private ColorButton(Color color) {
			this.color = color;
			this.setPrefWidth(35);
			this.setPrefHeight(35);
			this.setBackground(new Background(new BackgroundFill(color, null, null)));
			this.setOnMouseClicked(event -> {
				selectedColor = color;

			});

		}

	}

	private class ShapeButton extends Button {

		private Shape shape;

		private ShapeButton(ShapeNames shape) {
			this.setPrefWidth(35);
			this.setPrefHeight(35);
			this.setOnMouseClicked(event -> {
				selectedShape = shape;

			});

		}

	}
}
