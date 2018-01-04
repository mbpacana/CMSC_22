/**
 * Class to generalize all types of plants.
 */
public abstract class Plant extends Character {
    private int sunlightCost;

    public Plant(int hp, int damage, int sunlightCost) {
        super(hp, damage);
        this.sunlightCost = sunlightCost;
    }

    public int produce(){
        return 100;
    }

    public abstract int getSunlightCost();


}
