import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyTriangle extends Shape {

	private static final long serialVersionUID = 1L;

	public MyTriangle(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void drawYourself(GraphicsContext g) {
		g.setFill(getColor());
		g.fillPolygon(new double[] { getX(), getX() + getWidth(),getX() + getWidth() / 2 },
				new double[] { getY() + getHeight(), getY() + getHeight(), getY() }, 3);

	}

}
