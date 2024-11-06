package player;

import inventory.Inventory;
import player.characters.Archer;
import player.characters.Knight;
import player.characters.Samurai;

import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String playerClass;

    public Player(Inventory inventory, int damage, int health, int money,String name, String playerClass) {
        this.inventory = inventory;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
        this.playerClass = playerClass;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public Player selectCharacter(){
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        this.name = scanner.nextLine();

        Player chosenCharacter = null;

        System.out.println("Choose a character:");
        System.out.println("1- Samurai, Damage: 5, Health: 21, Money: 15");
        System.out.println("2- Archer, Damage: 7, Health: 18, Money: 20");
        System.out.println("3- Knight, Damage: 8, Health: 24, Money: 5");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                chosenCharacter = new Samurai(this.inventory, 5, 21, 15, this.name ,"Samurai");
                break;
            case 2:
                chosenCharacter = new Archer(this.inventory, 7, 18, 20, this.name, "Archer");
                break;
            case 3:
                chosenCharacter = new Knight(this.inventory, 8, 24, 5, this.name, "Knight");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid character.");
                return selectCharacter();
        }
        System.out.println("Adventurer " + chosenCharacter.getName() + " selected the " + chosenCharacter.getPlayerClass() + " class.");
        System.out.println("Attributes - Damage: " + chosenCharacter.getDamage() + " Health: " + chosenCharacter.getHealth() + " Money: " + chosenCharacter.getMoney() );
        System.out.println("=========================================================");

        return chosenCharacter;
    }
}