import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

	private int width = 25;
	private int height = 25;

	public abstract void drawYourself(GraphicsContext g, int x, int y, Color color);

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
