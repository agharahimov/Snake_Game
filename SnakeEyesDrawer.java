import java.awt.*;

/**
 * Utility class for drawing eyes on the snake's head.
 */
public class SnakeEyesDrawer {

    /**
     * Draws eyes on the snake's head based on its direction of movement.
     *
     * @param g          The Graphics object to draw on.
     * @param tileSize   The size of each tile on the game board.
     * @param snakeHeadX The x-coordinate of the snake's head.
     * @param snakeHeadY The y-coordinate of the snake's head.
     * @param velocityX  The horizontal velocity of the snake.
     * @param velocityY  The vertical velocity of the snake.
     */
    public static void drawEyes(Graphics g, int tileSize, int snakeHeadX, int snakeHeadY, int velocityX, int velocityY) {
        g.setColor(Color.black);
        int eyeSize = tileSize / 5; // Size of the eyes
        int eyeDistance = tileSize / 6; // Distance of the eyes from the edges

        // Calculate eye positions based on the direction of movement
        if (velocityX > 0) { // Moving right
            // Draw eyes on the right side of the head
            int rightEyeX = snakeHeadX * tileSize + tileSize - eyeDistance - eyeSize;
            int leftEyeX = rightEyeX - eyeDistance - eyeSize; // Calculate position for the left eye
            int eyeCenterY = snakeHeadY * tileSize + tileSize / 2; // Y coordinate of the eye center
            g.fillOval(rightEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
            g.fillOval(leftEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
        } else if (velocityX < 0) { // Moving left
            // Draw eyes on the left side of the head
            int leftEyeX = snakeHeadX * tileSize + eyeDistance;
            int rightEyeX = leftEyeX + eyeDistance + eyeSize; // Calculate position for the right eye
            int eyeCenterY = snakeHeadY * tileSize + tileSize / 2; // Y coordinate of the eye center
            g.fillOval(leftEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
            g.fillOval(rightEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
        } else { // Moving up or down
            // Draw eyes at the center of the head vertically
            int eyeCenterX = snakeHeadX * tileSize + tileSize / 2; // X coordinate of the eye center
            int eyeCenterY = snakeHeadY * tileSize + tileSize / 2; // Y coordinate of the eye center
            int leftEyeX = eyeCenterX - eyeDistance - eyeSize / 2;
            int rightEyeX = eyeCenterX + eyeDistance - eyeSize / 2;
            g.fillOval(leftEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
            g.fillOval(rightEyeX, eyeCenterY - eyeSize / 2, eyeSize, eyeSize);
        }
    }
}
