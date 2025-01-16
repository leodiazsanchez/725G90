import java.io.Serializable;
import javafx.scene.paint.Color;

public class SerializableColor implements Serializable {
	private static final long serialVersionUID = 1L;
	private double red;
	private double green;
	private double blue;
	private double alpha;

	public SerializableColor(Color color) {
		this.red = color.getRed();
		this.green = color.getGreen();
		this.blue = color.getBlue();
		this.alpha = color.getOpacity();
	}

	public SerializableColor(double red, double green, double blue, double alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public Color getColor() {
		return new Color(red, green, blue, alpha);
	}
}