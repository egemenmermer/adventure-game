package location.monsters;

public class Zombie extends Obstacle{
    private int damage = 3;
    private int health = 10;
    private int gold = 4;


    public Zombie(int damage, int health, int gold) {
        super(damage, health, gold);
    }

    @Override
    public String getName(){
        return "Zombie";
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
