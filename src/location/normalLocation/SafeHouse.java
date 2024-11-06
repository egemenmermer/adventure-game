package location.normalLocation;

import player.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House. Your health has been restored.");
        getPlayer().setHealth(getPlayer().getHealth());
        return true;
    }
}
