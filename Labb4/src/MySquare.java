import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare extends Shape {

	public MySquare(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourself(GraphicsContext g) {
		g.setFill(getColor());
		g.fillRect(getX(), getY(), 50, 50);
		
	}

}
