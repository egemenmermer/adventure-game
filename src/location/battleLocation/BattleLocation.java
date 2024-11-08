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

    public void combat(){
        Scanner in = new Scanner(System.in);
        System.out.println("==============================");
        int monsterCount = obstacle.obstacleNumber();
        int initialCount = monsterCount;
        boolean isFighting = true;

        System.out.println("Be careful! There are " + monsterCount + " vampires ahead!");
        System.out.println("What do you want to do?");
        System.out.println("========================");
        System.out.println("1- Attack!");
        System.out.println("2- Try to run! (50% chance)");
        int option = in.nextInt();

        switch(option){
            case 1:
                while (isFighting && monsterCount > 0){
                    this.obstacle.setHealth(obstacle.getInitialHealth());
                    while(this.obstacle.getHealth() > 0){

                        //Player Attack
                        this.obstacle.getHealth() -= getPlayer().getDamage();
                        System.out.println("Good hit! Remaining health of the opponent: " + this.obstacle.getHealth());
                        if (this.obstacle.getHealth() <= 0){
                            System.out.println("You defeated a " + this.obstacle.get );
                            monsterCount--;
                            break;
                        }

                        //Vampire Attack
                        System.out.println("Vampire is attacking!");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacle.getDamage());
                        System.out.println("Your remaining health: " + this.getPlayer().getHealth());
                        if (this.getPlayer().getHealth() <= 0){
                            System.out.println("You have been defeated!");
                            isFighting = false;
                            break;
                        }
                    }
                }
                if(getPlayer().getHealth() > 0 && monsterCount == 0){
                    System.out.println("You defeated all of the monsters!");
                    this.getPlayer().getInventory().setFirewood(true);
                    this.getPlayer().setMoney(getPlayer().getMoney() + (this.obstacle.getGold() * initialCount));
                    System.out.println("Gold earned: " + (this.obstacle.getGold() * initialCount));
                }
                break;
            case 2:
                if(Math.random() < 0.5){
                    System.out.println("You managed to escape!");
                }else {
                    System.out.println("You couldn't escape!");
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - this.damage);
                    break;
                }
        }
        }
    }
}
