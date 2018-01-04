import java.util.List;

/**
 * Created by User on 10/18/2016.
 */
public class Cherrybomb extends Plant implements SplashAttacker{

    private int turnCount;
    public Cherrybomb() {
        super(10, 150, 150);
        turnCount = 2;
    }

    public int getSunlightCost(){
        return 150;
    }

    public void splashAttack(List<Zombie> defenders) {
        if(turnCount!=0){
            turnCount--;
        }
        else{
            if(defenders.size() != 0) {
                int cdamage = 150;
                cdamage /= defenders.size();
                for (Zombie z : defenders) {
                    z.takeDamage(cdamage);
                }

            }
            setHp(0);
        }
    }


}
