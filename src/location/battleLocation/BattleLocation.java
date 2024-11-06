package location.battleLocation;

import location.Location;
import player.Player;

public abstract class BattleLocation extends Location {
    public BattleLocation(Player player, String name) {
        super(player, name);
    }
    //Obstacle obstacle;


}
