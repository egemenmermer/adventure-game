package game;

import inventory.Inventory;
import location.Location;
import location.battleLocation.BattleLocation;
import location.battleLocation.Cave;
import location.battleLocation.Forest;
import location.battleLocation.River;
import location.monsters.Bear;
import location.monsters.Obstacle;
import location.monsters.Vampire;
import location.monsters.Zombie;
import location.normalLocation.SafeHouse;
import location.normalLocation.ToolStore;
import player.Player;

import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;
    private Inventory inventory;

    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("================================");

        Player player = new Player(null, 0, 0, 0, null, null);
        this.player = player.selectCharacter();
        if (this.player == null) {
            System.out.println("Failed to select a character. Exiting.");
            return;
        }


        boolean isGameRunning = true;
        while(isGameRunning){
            System.out.println("Choose a location to proceed!");
            System.out.println("1- Safe House (Restore your health)");
            System.out.println("2- Tool Store (Buy Items)");
            System.out.println("3- Battle Locations (Fight)");
            System.out.println("4- Exit Game");

            int locationChoice = scanner.nextInt();
            switch (locationChoice){
                case 1:
                    SafeHouse safeHouse = new SafeHouse(player, "Safe House");
                    safeHouse.onLocation();
                    break;
                case 2:
                    ToolStore toolStore = new ToolStore(player, "Tool Store");
                    toolStore.onLocation();
                    break;
                case 3:
                    System.out.println("1- Cave (Easy)");
                    System.out.println("2- Forest (Medium)");
                    System.out.println("3- River (Hard)");
                    System.out.println("4- Go back to main menu");


                    int battleChoice = scanner.nextInt();
                    switch (battleChoice){
                        case 1:
                            System.out.println("Creating Zombie obstacle...");
                            Obstacle zombie = new Zombie(3,10,4);
                            BattleLocation cave = new Cave(player, "Cave", zombie);
                            cave.onLocation();
                        case 2:
                            Obstacle vampire = new Vampire(4,14,7);
                            BattleLocation forest = new Forest(player, "Forest", vampire);
                            forest.onLocation();
                        case 3:
                            Obstacle bear  = new Bear(7,20,12);
                            BattleLocation river = new River(player, "River", bear);
                            river.onLocation();
                        case 4:
                            System.out.println("Returning to main menu...");
                            break;
                        default:
                            System.out.println("Invalid choice! Please select a valid battle location.");

                    }
                case 4:
                    System.out.println("Exiting the game. Goodbye!");
                    isGameRunning = false;
                    break;
                default:
                    System.out.println("Invalid location choice! Please choose a valid location!");
                    break;
            }
        }
    }
}
