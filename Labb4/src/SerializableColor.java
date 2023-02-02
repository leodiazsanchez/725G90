
import java.io.Serializable;

import javafx.scene.paint.Color;

public class SerializableColor implements Serializable {
	// private static final long serialVersionUID = 1L;

	//private final Color color;

	public SerializableColor(Color color) {
		//this.color = color;
	}

	public Color getColor() {
		return Color.ALICEBLUE;
	}
}