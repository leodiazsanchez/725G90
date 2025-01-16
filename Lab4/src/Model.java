import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Model {
	private ArrayList<Shape> contents = new ArrayList<>();
	private Shape currentShape;
	private Color currentColor;

	public void setColor(Color c) {
		currentColor = c;
	}

	public void setShape(Shape s) {
		currentShape = s;
	}

	public Shape getShape() {
		return this.currentShape;
	}
	
	public Color getColor() {
		return this.currentColor;
	}

	public ArrayList<Shape> getContents() {
		return contents;

	}

	public void clear() {
		contents.clear();
	}
}
