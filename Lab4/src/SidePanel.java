import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SidePanel extends VBox {

	private Color[] colors = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
			Color.WHITE, Color.ORANGE };
	
	private Shape[] shapes = {new MyCircle(0,0, Color.BLACK), new MySquare(0,0, Color.BLACK), new MyTriangle(0,0, Color.BLACK)};
	
	private ArrayList<ColorButton> colorButtons = new ArrayList<>();
	private ArrayList<ShapeButton> shapeButtons = new ArrayList<>();

	public SidePanel(int x, int y, Color color, Model model) {
		this.setPrefWidth(x);
		this.setPrefHeight(y);
		this.setLayoutX(y - x - 15);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));
		this.setSpacing(10);
		this.setAlignment(Pos.TOP_CENTER);
		
		Label colorLabel = new Label("Färg");
		colorLabel.setTextFill(Color.BLACK);
		this.getChildren().add(colorLabel);

		for (Color c : colors) {
			ColorButton b = new ColorButton(c, model, this);
			colorButtons.add(b);
			this.getChildren().add(b);
		}

		Label shapeLabel = new Label("Former");
		shapeLabel.setTextFill(Color.BLACK);
		this.getChildren().add(shapeLabel);
		
		for (Shape s : shapes) {
			ShapeButton b = new ShapeButton(s, model, this);
			shapeButtons.add(b);
			this.getChildren().add(b);
		}

	}
	
	public ArrayList<ShapeButton> getShapeButtons() {
		return shapeButtons;
	}
	
	public ArrayList<ColorButton> getColorButtons() {
		return colorButtons;
	}

}
