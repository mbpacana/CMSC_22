/**
 * Created by User on 11/25/2016.
 */
public class King extends Character{
    public King(){
        this.weapon = new BowAndArrowBehavior();
    }
    public King(WeaponBehavior w){
        setWeapon(w);
    }
    public void fight(){
        System.out.println("King attacked!");
        weapon.useWeapon();
    }
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
