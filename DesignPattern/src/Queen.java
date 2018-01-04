/**
 * Created by User on 11/25/2016.
 */
public class Queen extends Character{
    public Queen(){
        this.weapon = new BowAndArrowBehavior();
    }
    public Queen(WeaponBehavior w){
        setWeapon(w);
    }
    public void fight(){
        System.out.println("Queen attacked!");
        weapon.useWeapon();
    }
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
