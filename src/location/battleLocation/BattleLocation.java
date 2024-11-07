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
        return combat();  // Start combat with the obstacle
    }

    public void combat(){
        Scanner in = new Scanner(System.in);
        System.out.println("==============================");
        int monsterCount = (int) ((Math.random() * 3) + 1);
        int initialCount = monsterCount;
        System.out.println(monsterCount);
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
                    this.health = 14;
                    while(this.health > 0){

                        //Player Attack
                        this.health -= getPlayer().getDamage();
                        System.out.println("Good hit! Remaining health of the opponent: " + this.health);
                        if (this.health <= 0){
                            System.out.println("You defeated a vampire!");
                            monsterCount--;
                            break;
                        }

                        //Vampire Attack
                        System.out.println("Vampire is attacking!");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.damage);
                        System.out.println("Your remaining health: " + this.player.getHealth());
                        if (this.getPlayer().getHealth() <= 0){
                            System.out.println("You have been defeated!");
                            isFighting = false;
                            break;
                        }
                    }
                }
                if(player.getHealth() > 0 && monsterCount == 0){
                    System.out.println("You defeated all of the monsters!");
                    this.getPlayer().getInventory().setFirewood(true);
                    this.getPlayer().setMoney(getPlayer().getMoney() + (this.gold * initialCount));
                    System.out.println("Gold earned: " + (this.gold * initialCount));
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
