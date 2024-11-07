package location.monsters;

public class Obstacle {
    private int obstacleNumber;

    public Obstacle() {
        // Initialize obstacle count or other properties here if needed
        this.obstacleNumber = (int) (Math.random() * 3) + 1;  // Randomly set the number of obstacles (1-3)
    }

    public int obstacleNumber() {
        return this.obstacleNumber;
    }
}
