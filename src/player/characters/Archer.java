package player.characters;

import inventory.Inventory;
import player.Player;

public class Archer extends Player {
    int health;
    int damage;

    public Archer(Inventory inventory, int damage, int health, int money,String name, String playerClass) {
        super(inventory, damage, health, money ,name ,playerClass);
    }


}
