package location.monsters;

import player.Player;

import java.util.Scanner;

public class Vampire extends Obstacle{
    private int damage;
    private int health;
    private int gold;
    private String monsterName;

    public Vampire(int damage, int health, int gold) {
        super(damage, health, gold);
        this.monsterName = "Vampire";
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
