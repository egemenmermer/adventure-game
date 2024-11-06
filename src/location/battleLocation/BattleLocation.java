package location.battleLocation;

import location.Location;
import location.monsters.Obstacle;
import player.Player;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle) {
        super(player, name);
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }

    public void combat(){

    }
}
