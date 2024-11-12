package location.monsters;

public class Zombie extends Obstacle{
    private int damage;
    private int health;
    private int gold;


    public Zombie(int damage, int health, int gold) {
        super(health, damage, gold);
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
