/**
 * Created by User on 11/25/2016.
 */
public class Knight extends Character{
    public Knight(){
        this.weapon = new BowAndArrowBehavior();
    }
    public Knight(WeaponBehavior w){
        setWeapon(w);
    }
    public void fight(){
        System.out.println("Knight attacked!");
        weapon.useWeapon();
    }
    public void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
