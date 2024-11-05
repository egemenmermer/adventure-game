package player;

import inventory.Inventory;
import player.characters.Samurai;

import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String playerClass;

    public Player(Inventory inventory, int damage, int health, int money, String name) {
        this.inventory = inventory;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
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

    public void selectCharacter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        this.name = scanner.nextLine();
        boolean validChoice = false;

        System.out.println("Choose a character:");
        System.out.println("1- Samurai, Damage: 5, Health: 21, Money: 15");
        System.out.println("2- Archer, Damage: 7, Health: 18, Money: 20");
        System.out.println("3- Knight, Damage: 8, Health: 24, Money: 5");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Samurai samurai = new Samurai(inventory,5,21,15);
                break;

            case 2:
                this.playerClass = "Archer";
                this.damage = 7;
                this.health = 18;
                this.money = 20;
                validChoice = true;
                break;

            case 3:
                this.playerClass = "Knight";
                this.damage = 8;
                this.health = 24;
                this.money = 50;
                validChoice = true;
                break;

            default:
                System.out.println("Invalid choice. Please select a valid character.");
                break;
        }
        System.out.println("Adventurer " + this.getName() + " selected the " + this.playerClass + " class.");
        System.out.println("Attributes - Damage: " + this.getDamage() + " Health: " + this.getHealth() + " Money: " + this.getMoney() );

    }
}