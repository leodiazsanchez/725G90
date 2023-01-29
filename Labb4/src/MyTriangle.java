import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyTriangle extends Shape {

	public MyTriangle(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourself(GraphicsContext g) {
		g.setFill(getColor());
		g.fillPolygon(new double[] { getX(), getX() + 50, getX() + 25 },
				new double[] { getY() + 50, getY() + 50, getY() }, 3);

	}

}
