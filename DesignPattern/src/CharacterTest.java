/**
 * Created by User on 11/25/2016.
 */
public class CharacterTest {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.fight();
        q = new Queen(new KnifeBehavior());
        q.fight();
        q = new Queen(new SwordBehavior());
        q.fight();
        q = new Queen(new BowAndArrowBehavior());
        q.fight();
        q = new Queen(new AxeBehavior());
        q.fight();

        King k = new King();
        k.fight();
        k = new King(new KnifeBehavior());
        k.fight();
        k = new King(new SwordBehavior());
        k.fight();
        k = new King(new BowAndArrowBehavior());
        k.fight();
        k = new King(new AxeBehavior());

        Troll t = new Troll();
        t.fight();
        t = new Troll(new KnifeBehavior());
        t.fight();
        t = new Troll(new SwordBehavior());
        t.fight();
        t = new Troll(new BowAndArrowBehavior());
        t.fight();
        t = new Troll(new AxeBehavior());

        Knight kn = new Knight();
        kn.fight();
        kn = new Knight(new KnifeBehavior());
        kn.fight();
        kn = new Knight(new SwordBehavior());
        kn.fight();
        kn = new Knight(new BowAndArrowBehavior());
        kn.fight();
        kn = new Knight(new AxeBehavior());
    }
;}
