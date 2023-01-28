import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
	private int x,y;
	private Color myColor;
	
	public Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.myColor = color;
	}
	
	
	public abstract void drawYourself(GraphicsContext g);


	public Color getColor() {
		return myColor;
	}


	public void setColor(Color myColor) {
		this.myColor = myColor;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
