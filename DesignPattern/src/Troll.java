/**
 * Created by User on 11/25/2016.
 */
public class Troll extends Character{
    public Troll(){
        System.out.println("Troll attacked!");
        this.weapon = new BowAndArrowBehavior();
    }
    public Troll(WeaponBehavior w){
        System.out.println("Troll attacked!");
        setWeapon(w);
    }
    public void fight(){
        weapon.useWeapon();
    }
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
