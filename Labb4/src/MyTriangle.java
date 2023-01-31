import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyTriangle extends Shape {

	@Override
	public void drawYourself(GraphicsContext g, int x, int y, Color color) {
		g.setFill(color);
		g.fillPolygon(new double[] { x, x + getWidth(),x + getWidth() / 2 },
				new double[] { y + getHeight(), y + getHeight(), y }, 3);

	}

}
