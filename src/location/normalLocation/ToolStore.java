package location.normalLocation;

import player.Player;

import java.util.Scanner;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in the Tool Store!");
        menu();
        return true;
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");

        int playerChoice = scanner.nextInt();


        if(playerChoice == 1){
            int weaponChoice;
            System.out.println("1- Pistol - Damage: 2, Cost: 25");
            System.out.println("2- Sword - Damage: 3, Cost: 35");
            System.out.println("3- Rifle - Damage: 7, Cost: 45");
            weaponChoice = scanner.nextInt();
            switch (weaponChoice){
                case 1:
                    buy("weapon", "pistol", 2, 25);
                    break;
                case 2:
                    buy("weapon", "sword", 3, 35);
                    break;
                case 3:
                    buy("weapon", "rifle", 7, 45);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    menu();
                    break;
                }
        } else if(playerChoice == 2){
            int armorChoice;
            System.out.println("1- Small Armor - Damage Reduction: 1, Cost: 15");
            System.out.println("2- Medium Armor - Damage Reduction: 3, Cost: 25");
            System.out.println("3- Large Armor - Damage Reduction: 5, Cost: 40");
            armorChoice = scanner.nextInt();
            switch (armorChoice){
                case 1:
                    buy("armor", "small_armor", 1, 15);
                    break;
                case 2:
                    buy("armor", "medium_armor", 3, 25);
                    break;
                case 3:
                    buy("armor", "large_armor", 5, 40);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    menu();
                    break;
            }
        }
    }

    public void buy(String itemType, String itemName, int effect, int cost){
        if(getPlayer().getMoney() >= cost){
            getPlayer().setMoney(getPlayer().getMoney() - cost);
            if(itemType.equals("weapon")){
                getPlayer().getInventory().setWeaponName(itemName);
                getPlayer().getInventory().setWeaponDamage(effect);
            }else if(itemType.equals("armor")){
                getPlayer().getInventory().setArmorName(itemName);
                getPlayer().getInventory().setArmorDamage(effect);
            }
            System.out.println("You bought " + itemName +"! Remaining money: " + getPlayer().getMoney());
        }else{
            System.out.println("You don't have enough money to buy this item!");
        }
    }
}
