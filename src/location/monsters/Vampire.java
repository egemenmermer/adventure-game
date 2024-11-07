package location.monsters;

import player.Player;

import java.util.Scanner;

public class Vampire extends Obstacle{
    private int damage = 4;
    private int health = 14;
    private int gold = 7;

    public Vampire(int damage, int health, int gold) {
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
