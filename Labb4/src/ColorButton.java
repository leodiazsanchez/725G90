import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class ColorButton extends Canvas{
	private Color myColor;
	
	private ColorButton(Color color) {
		this.myColor = color;
		this.setWidth(10);
		this.setHeight(10);
	}
}
