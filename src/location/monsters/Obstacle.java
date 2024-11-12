package location.monsters;

public class Obstacle {
    private int initialHealth;
    private int obstacleNumber;
    private int health;
    private int damage;
    private int gold;

    public Obstacle(int health, int damage, int gold) {
        this.initialHealth = initialHealth;
        this.health = health;
        this.damage = damage;
        this.gold = gold;
    }

    public static int obstacleNumber() {
        return (int) (Math.random() * 3) + 1;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    public void resetHealth() {
        this.health = initialHealth;
    }
}
