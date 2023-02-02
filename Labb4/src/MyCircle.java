import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends Shape {

	public MyCircle(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void drawYourself(GraphicsContext g) {
		g.setFill(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());

	}

}
