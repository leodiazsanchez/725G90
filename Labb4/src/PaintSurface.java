
import javafx.scene.canvas.Canvas;

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
