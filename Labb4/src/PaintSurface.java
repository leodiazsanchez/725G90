import javafx.scene.canvas.Canvas;

public class PaintSurface extends Canvas{
	private Model myModel;
	
	public PaintSurface(int x, int y) {
		super(x,y);
	}

	public void clear() {
		System.out.println("Hej");
		//myModel.clear();
	}

}
