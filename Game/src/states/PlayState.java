package states;

import constants.Constants;
import gameElements.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * This state represents the Playing State of the Game. The main responsibility
 * of this class is to:
 * - create Game Objects
 * - update Game Objects
 * - draw Game Objects, such as players, enemies, power-ups, etc.
 */
public class PlayState extends GameState implements Constants {

	private Image bg;
	private final ArrayList<Pipe> pipes = new ArrayList<>();
	private final ArrayList<Enemy> enemies = new ArrayList<>();
	private final ArrayList<PowerUp> powerUps = new ArrayList<>();
	private Player player;
	private final SortedScoreList topScores;
	private int score;
	private final boolean hard;
	private LevelManager lm;

	// Audio
	private MediaPlayer themePlayer;
	private MediaPlayer scorePlayer;
	private MediaPlayer powerUpPlayer;
	private MediaPlayer hitPlayer;

	/**
	 * Constructs a new PlayState object with the specified GameModel and top scores list.
	 * Sets the background image, theme player, sound effect players, and hard mode flag.
	 *
	 * @param model the GameModel object to associate with this PlayState
	 * @param topScores the SortedScoreList object containing the top scores to display
	 * @param hard a boolean flag indicating whether or not hard mode is enabled
	 */
	public PlayState(GameModel model, SortedScoreList topScores, boolean hard) {
		super(model);

		// Load background image
		InputStream inputStream = getClass().getResourceAsStream("/images/bg.gif");
		if (inputStream == null) {
			throw new RuntimeException("Background image not found!");
		}
		bg = new Image(inputStream);

		this.hard = hard;

		String audioFile = hard ? "/sounds/mlg.mp3" : "/sounds/theme.mp3";
		themePlayer = addMediaPlayer(audioFile);
		scorePlayer = addMediaPlayer("/sounds/score.mp3");
		powerUpPlayer = addMediaPlayer("/sounds/powerup.mp3");
		hitPlayer = addMediaPlayer("/sounds/hit.mp3");

		this.topScores = topScores;
	}

	/**
	 * Draws the game state on the given graphics context.
	 *
	 * @param g the graphics context to draw on
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.drawImage(bg, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		player.draw(g);

		for (Pipe obj : pipes) {
			obj.draw(g);
		}

		for (Enemy enemy : enemies) {
			enemy.draw(g);
		}

		for (PowerUp powerUp : powerUps) {
			powerUp.draw(g);
		}

		drawScore(g);
	}

	/**
	 * Draws the current score on the canvas.
	 *
	 * @param g the graphics context to draw on
	 */
	private void drawScore(GraphicsContext g) {
		g.setStroke(Color.BLACK);
		g.setLineWidth(2);
		g.setFill(Color.WHITE);

		Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/FlappyBird.ttf"), 50);
		if (customFont == null) {
			throw new RuntimeException("Font not found!");
		}
		g.setFont(customFont);
		g.strokeText(String.valueOf(score), SCREEN_WIDTH / 2 - 25, 100);
		g.fillText(String.valueOf(score), SCREEN_WIDTH / 2 - 25, 100);
	}

	/**
	 * Handles key press events. If the user presses the ESCAPE key, the game state is switched
	 * to the MenuState and the theme music is stopped.
	 *
	 * @param key the key event that triggered this method
	 */
	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model, topScores));
			if (themePlayer != null) {
				themePlayer.stop();
			}
		}
	}

	@Override
	public void handleMouseInput(MouseEvent mouseEvent) {
		// No implementation needed for now
	}

	/**
	 * Updates the game state based on the current timestamp and the keys pressed.
	 *
	 * @param now the current timestamp in nanoseconds
	 * @param keysPressed a Set of KeyCode representing the keys currently pressed
	 */
	@Override
	public void update(long now, Set<KeyCode> keysPressed) {
		player.update(keysPressed);
		lm.update(now, score);

		updatePipes(now);
		updateEnemies(now);
		updatePowerUps(now);
	}

	/**
	 * Activates the game state by starting the background theme player, initializing the player object and level manager.
	 */
	@Override
	public void activate() {
		if (themePlayer != null) {
			themePlayer.play();
		}

		player = new Player(100, SCREEN_HEIGHT / 2, 60, 40, "/images/woody.png");
		lm = new LevelManager(pipes, enemies, powerUps, hard);
	}

	/**
	 * We currently don't have anything to deactivate in the PlayState, so we leave
	 * this method empty.
	 */
	@Override
	public void deactivate() {

	}

	/**
	 * Creates a new {@link MediaPlayer} instance with the specified sound file and sets its properties for playing in the game.
	 *
	 * @param filePath the path of the sound file to be played by the media player
	 * @return the new media player instance with the sound file loaded and configured
	 */
	private MediaPlayer addMediaPlayer(String filePath) {
		// Get the URL for the media file from the resources folder
		URL mediaUrl = getClass().getResource(filePath);

		if (mediaUrl != null) {
			// Convert URL to URI and create the Media object
			Media sound = new Media(mediaUrl.toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			prepareMediaPlayer(mediaPlayer);
			return mediaPlayer;
		} else {
			System.out.println("Media file not found: " + filePath);
			return null;
		}
	}


	/**
	 * Prepares a media player by setting its volume, balance, cycle count, and on end of media behavior.
	 *
	 * @param mediaPlayer the media player to prepare
	 */
	private void prepareMediaPlayer(MediaPlayer mediaPlayer) {
		if (mediaPlayer != null) {
			mediaPlayer.setVolume(0.1);
			mediaPlayer.setBalance(0.0);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.setOnEndOfMedia(() -> {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			});
		}
	}

	/**
	 * Ends the current game session and switches to the Game Over state, passing the current game score and the list of top scores to the new state.
	 * Stops the theme music from playing.
	 */
	private void gameOver() {
		topScores.add(score);
		model.switchState(new GameOverState(model, topScores, hard));
		if (themePlayer != null) {
			themePlayer.stop();
		}
	}

	// Helper methods for updating the different game elements

	private void updatePipes(long now) {
		Iterator<Pipe> pipeIterator = pipes.iterator();
		while (pipeIterator.hasNext()) {
			Pipe pipe = pipeIterator.next();
			pipe.update();

			if (player.checkCollision(pipe) && player.invincible(now)) {
				gameOver();
			}

			if (player.getX() >= pipe.getX()) {
				if (!pipe.getScored()) {
					score += player.doubleScore(now) ? 2 : 1;
					if (scorePlayer != null) {
						scorePlayer.play();
					}
					pipe.scored();
				}
			}

			if (pipe.getX() + pipe.getWidth() < 0) {
				pipeIterator.remove();
			}
		}
	}

	private void updateEnemies(long now) {
		Iterator<Enemy> enemyIterator = enemies.iterator();
		while (enemyIterator.hasNext()) {
			Enemy enemy = enemyIterator.next();
			enemy.update();

			if (player.checkCollision(enemy) && !enemy.hasCollided()) {
				score = Math.max(0, score - enemy.getDamage());
				enemy.setHasCollided();
				if (hitPlayer != null) {
					hitPlayer.play();
				}
				enemyIterator.remove();
			}

			if (enemy.getX() + enemy.getWidth() < 0 || enemy.getY() > SCREEN_HEIGHT) {
				enemyIterator.remove();
			}
		}
	}

	private void updatePowerUps(long now) {
		Iterator<PowerUp> powerUpIterator = powerUps.iterator();
		while (powerUpIterator.hasNext()) {
			PowerUp powerUp = powerUpIterator.next();
			powerUp.update();

			if (player.checkCollision(powerUp)) {
				powerUp.activate(now);
				powerUp.effect(player);
				if (powerUpPlayer != null) {
					powerUpPlayer.play();
				}
				powerUpIterator.remove();
			}

			if (powerUp.getX() + powerUp.getWidth() < 0) {
				powerUpIterator.remove();
			}
		}
	}
}
