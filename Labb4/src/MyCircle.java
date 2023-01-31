import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends Shape {

	@Override
	public void drawYourself(GraphicsContext g, int x, int y, Color color) {
		g.setFill(color);
		g.fillOval(x, y, getWidth(), getHeight());

	}

}
