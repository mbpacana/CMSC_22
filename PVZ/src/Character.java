/**
 * Class to represent all characters on the board.
 */
public abstract class Character {
    private int hp;
    private int damage;

    public Character(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }

    // subtract damage points inflicted on this character
    public void takeDamage(int damage) {
        if(damage < hp){
            hp -=damage;
        }
        else {
            hp = 0;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // applies damage to given defender
    public void attack(Character defender) {
        defender.takeDamage(damage);
    }

    // returns true if alive
    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    public int getDamage() {
        return damage;
    }
}
