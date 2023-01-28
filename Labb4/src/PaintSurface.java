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
		this.setOnMouseClicked(handler);

	}

	private EventHandler<InputEvent> handler = new EventHandler<InputEvent>() {
		public void handle(InputEvent event) {
			System.out.println("hej");
			myModel.getContents().add(new MyCircle(MouseInfo.getPointerInfo().getLocation().x,
					MouseInfo.getPointerInfo().getLocation().y, Color.BLACK));
			event.consume();
		}
	};

	public Model getModel() {

		return myModel;
	}

}
