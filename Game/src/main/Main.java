package main;

import constants.Constants;
import gameElements.SortedScoreListIO;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import states.GameModel;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * This Class is the entry point of the application.
 * <p>
 * This Class has the following primary responsibilities: 1. Serve as the entry
 * for the Application
 * <p>
 * 2. Create the GameModel (For more information about the GameModel see
 * /src/states/GameModel)
 * <p>
 * 3. Create the GameFrame (A HBox Wrapper): (For more information about the
 * GameFrame see /src/main/GameFrame)...
 * <p>
 * 4. Create the GamePanel (A VBOx Wrapper): (For more information about the
 * GamePanel see /src/main/GamePanel)...
 * <p>
 * 5. Run the main loop of the game.
 * <p>
 * <a href="https://gitlab.liu.se/magni54/ExempelProjekt-TDDE10_725G90">...</a>
 *
 * @author magni54, alomi60
 */
public class Main extends Application implements Constants {
	private final Set<KeyCode> keysPressed = new HashSet<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage gameStage) {
		InputStream inputStream = getClass().getResourceAsStream("/images/woody.png");
		gameStage.getIcons().add(new Image(inputStream));
		gameStage.setTitle("Peck n Flap");
		gameStage.setWidth(SCREEN_WIDTH);
		gameStage.setHeight(SCREEN_HEIGHT);

		GameModel model = new GameModel();
		GameFrame frame = new GameFrame(model, SCREEN_WIDTH, SCREEN_HEIGHT);
		Scene gameScene = new Scene(frame);

		gameStage.setScene(gameScene);

		// Key input handling
		gameScene.setOnKeyPressed(event -> {
			model.keyPressed(event);
			keysPressed.add(event.getCode());
		});

		gameScene.setOnKeyReleased(event -> keysPressed.remove(event.getCode()));
		gameScene.setOnMouseClicked(model::handleMouseInput);

		// Animation Timer for game loop
		new AnimationTimer() {
			private static final double TIME_STEP = 1_000_000_000.0 / 60.0; // 60 updates per second
			private long lastTime = 0;
			private double accumulatedTime = 0;

			@Override
			public void handle(long now) {
				if (lastTime == 0) {
					lastTime = now;
					return;
				}

				// Calculate elapsed time
				double deltaTime = now - lastTime;
				lastTime = now;
				accumulatedTime += deltaTime;

				// Perform updates at a fixed rate
				while (accumulatedTime >= TIME_STEP) {
					model.update(now, keysPressed);
					accumulatedTime -= TIME_STEP;
				}

				// Render as fast as possible
				frame.repaint();
			}
		}.start();

		// Save scores and gracefully exit
		gameStage.setOnCloseRequest(event -> {
			SortedScoreListIO.saveToFile(model.getScores(), "/data/highscore.txt");
			System.exit(0);
		});

		gameStage.setResizable(false);
		gameStage.show();
	}
}