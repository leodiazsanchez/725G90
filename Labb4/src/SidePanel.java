
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

		private Shape s;

		private ShapeButton(ShapeNames shape) {
			this.setPrefWidth(35);
			this.setPrefHeight(35);
			int x = (int) this.getLayoutX();
			int y = (int) this.getLayoutY();

			//MyCircle circle = new MyCircle(0, 0, Color.BLUE);
			
			//this.setGraphic(circle);
			switch (shape) {
		
			case CIRCLE:
				s = new MySquare(0, 0, Color.BLACK);
				break;
			case SQUARE:
				s = new MyCircle(0, 0, Color.BLACK);
				break;
			case TRIANGLE:
				s = new MyTriangle(0, 0, Color.BLACK);
				break;
			}
			Canvas canvas = new Canvas(35, 35);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			s.drawYourself(gc);
			this.setGraphic(canvas);
//			this.setGraphic(circle);

			this.setOnMouseClicked(event -> {
				selectedShape = shape;

			});

		}

	}
}
