import java.awt.MouseInfo;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.InputEvent;
import javafx.scene.paint.Color;

public class PaintSurface extends Canvas {
	private Model myModel;

	public PaintSurface(int x, int y) {
		super(x, y);
		myModel = new Model();

	}

	public Model getModel() {

		return myModel;
	}

}
