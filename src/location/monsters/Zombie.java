package location.monsters;

public class Zombie extends Obstacle{
    private int damage = 7;
    private int health = 20;
    private int gold = 12;


    public Zombie(int damage, int health, int gold) {
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
