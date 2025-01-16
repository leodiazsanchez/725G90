import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ShapeButton extends Button {

	public ShapeButton(Shape shape, Model model, SidePanel sPanel) {
		this.setPrefWidth(25);
		this.setPrefHeight(25);
		this.setFocusTraversable(false);
		Canvas canvas = new Canvas(this.getPrefWidth(), this.getPrefHeight());
		GraphicsContext gc = canvas.getGraphicsContext2D();
		shape.drawYourself(gc);
		this.setGraphic(canvas);

		this.setOnMouseClicked(event -> {
			
			for (ShapeButton b : sPanel.getShapeButtons()) {
				b.setBorder(null);
			}
			
			this.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

			model.setShape(shape);

		});

	}

}
