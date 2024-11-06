package location.monsters;

public class Bear extends Obstacle{
    private  int damage = 3;
    private  int health = 20;
    private  int gold = 12;


    @Override
    public boolean onLocation() {
        return false;
    }
}
