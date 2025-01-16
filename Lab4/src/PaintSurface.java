import javafx.scene.canvas.Canvas;

public class PaintSurface extends Canvas {
	private Model model;

	public PaintSurface(int x, int y, Model model) {
		super(x, y);
		this.model = model;
		
		this.setOnMouseDragged(event -> {
			try {
				this.draw((int) event.getX(), (int) event.getY());
			} catch (NullPointerException npe) {
				System.out.println("No shape or color selected");
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		
		});
		
		this.setOnMouseClicked(event -> {
			try {
				this.draw((int) event.getX(), (int) event.getY());
			} catch (NullPointerException npe) {
				System.out.println("No shape or color selected");
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		
		});

	}

	public void draw(int x, int y) throws CloneNotSupportedException {
		Shape shape = (Shape) model.getShape().clone();
		shape.setX(x);
		shape.setY(y);
		shape.setColor(model.getColor());
		model.getContents().add(shape);
		shape.drawYourself(getGraphicsContext2D());

	}

	public void clear(int windowWidth, int windowHeight) {
		this.getGraphicsContext2D().clearRect(0, 0, windowWidth, windowHeight);

	}

}
