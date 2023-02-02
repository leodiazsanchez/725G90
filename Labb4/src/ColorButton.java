import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ColorButton extends Button {

		public ColorButton(Color color, Model model) {
			this.setPrefWidth(35);
			this.setPrefHeight(35);
			this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), null)));
			this.setOnMouseClicked(event -> {
				Color borderColor  = (color.equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
				this.setBorder(new Border(new BorderStroke(borderColor, BorderStrokeStyle.SOLID, new CornerRadii(8),
						new BorderWidths(2))));
				model.setColor(color);
			});
			

		}

	}
