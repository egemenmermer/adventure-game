package location.NormalLocation;

import location.Location;

public abstract class NormalLocation extends Location {

    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }
}
