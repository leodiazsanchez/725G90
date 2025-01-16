import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class BottomPanel extends HBox {

	public BottomPanel(int x, int y, Color color, Model model, PaintSurface ps) {
		this.setPrefWidth(x);
		this.setLayoutY(y - 62);
		this.setSpacing(10);
		this.setBackground(new Background(new BackgroundFill(color, null, null)));

		Button clearButton = new Button("Rensa");
		this.getChildren().add(clearButton);
		clearButton.setOnMouseClicked(event -> {
			model.clear();
			ps.getGraphicsContext2D().clearRect(0, 0, x, y);
		});

		Button saveButton = new Button("Save");
		this.getChildren().add(saveButton);
		saveButton.setOnMouseClicked(event -> {
			
			for (Shape s : model.getContents()) {
				System.out.println(s);
			}
			
			FileChooser fc = new FileChooser();
			File file = fc.showSaveDialog(null);

			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(model.getContents());
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		Button openButton = new Button("Open");
		this.getChildren().add(openButton);
		openButton.setOnMouseClicked(event -> {
			
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(null);

			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				model.getContents().clear();
				ArrayList<Shape> shapes = (ArrayList<Shape>) ois.readObject();
				
				for (Shape s : shapes) {
					model.setShape(s);
					ps.draw(s.getX(), s.getY());
				}

				fis.close();
			} catch (EOFException e) {
				// End of file reachedcatch
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
