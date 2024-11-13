package location.battleLocation;

import location.Location;
import location.monsters.Obstacle;
import player.Player;

import java.util.Scanner;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle) {
        super(player, name);
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        System.out.println("You've entered " + this.getName());
        combat();
        return true;
    }

    public void combat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================");
        int monsterCount = obstacle.obstacleNumber();
        int initialCount = monsterCount;
        boolean isFighting = true;
        System.out.println("Be careful! There are " + monsterCount + " " + this.obstacle.getName() + " ahead!"); //which monster
        System.out.println("What do you want to do?");
        System.out.println("========================");
        System.out.println("1- Attack!");
        System.out.println("2- Try to run! (50% chance)");
        int option = sc.nextInt();


        switch (option) {
            case 1:
                while (isFighting && monsterCount > 0) {
                    this.obstacle.resetHealth();
                    System.out.println("A new " + obstacle.getName() + " appears with " + this.obstacle.getHealth() + " health.");
                    System.out.println(monsterCount);
                    System.out.println(this.obstacle.getHealth());
                    System.out.println(this.getPlayer().getName());

                    while (this.obstacle.getHealth() > 0 && this.getPlayer().getHealth() > 0) {
                        // Player Attack
                        this.obstacle.setHealth(obstacle.getHealth() - getPlayer().getDamage());
                        System.out.println("You attack! " + obstacle.getName() + " health is now " + obstacle.getHealth());

                        if (obstacle.getHealth() <= 0) {
                            System.out.println("You defeated a " + obstacle.getName() + "!");
                            monsterCount--;
                            break;
                        }

                        System.out.println(obstacle.getName() + " attacks you!");
                        getPlayer().setHealth(getPlayer().getHealth() - obstacle.getDamage());
                        System.out.println("Your remaining health: " + getPlayer().getHealth());

                        if (getPlayer().getHealth() <= 0) {
                            System.out.println("You have been defeated!");
                            isFighting = false;
                            break;
                        }
                    }
                }
                if (getPlayer().getHealth() > 0 && monsterCount == 0) {
                    System.out.println("You defeated all of the " + obstacle.getName() + "(s)!");
                    getPlayer().setMoney(getPlayer().getMoney() + (obstacle.getGold() * initialCount));
                    System.out.println("Gold earned: " + (obstacle.getGold() * initialCount));

                    if (this.getName().equals("Forest")) {
                        getPlayer().getInventory().setFirewood(true);
                        System.out.println("You found some firewood!");
                    } else if (this.getName().equals("Cave")) {
                        getPlayer().getInventory().setFood(true);
                        System.out.println("You found some food!");
                    } else if (this.getName().equals("River")) {
                        getPlayer().getInventory().setWater(true);
                        System.out.println("You found some water!");
                    }
                }
            case 2:
                if (Math.random() < 0.5) {
                    System.out.println("You managed to escape!");
                } else {
                    System.out.println("You couldn't escape! The " + obstacle.getName() + " attacks you as you try to flee.");
                    getPlayer().setHealth(getPlayer().getHealth() - obstacle.getDamage());
                    System.out.println("Your remaining health: " + getPlayer().getHealth());
                }
                break;
            default:
                System.out.println("Invalid option. Choose again.");
                break;
        }
    }
}