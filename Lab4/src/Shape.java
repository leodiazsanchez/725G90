import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private int width = 25;
	private int height = 25;
	private int x, y;
	private SerializableColor color;

	public Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = new SerializableColor(color);
	}

	public abstract void drawYourself(GraphicsContext g);

	public int getHeight() {
		return height;
	}

	public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
	public int getWidth() {
		return width;
	}

	public Color getColor() {
		return color.getColor();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int value) {
		this.x = value;
	}

	public void setY(int value) {
		this.y = value;
	}

	public void setColor(Color color) {
		this.color = new SerializableColor(color);

	}

	public String toString() {
		return (x + ":X " + y + ":Y");
	}

}
