import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare extends Shape {

	@Override
	public void drawYourself(GraphicsContext g, int x, int y, Color color) {
		g.setFill(color);
		g.fillRect(x, y, getWidth(), getHeight());

	}

}
