package Monsters;
import java.util.Random;

public class MediumMonster extends Enemy {
    private int mediumMaxAttack;
    

    public MediumMonster(int life) {
        super(life);
        this.mediumMaxAttack = 40;
    }

    public int getMaxAttack(){
        return this.mediumMaxAttack;
    }

    // @Override
    // public int getLife() {
    //     return life;
    // }


    // @Override
    // public void getAttacked(int damage) {
    //     this.life = life - damage;        
    // }


    @Override
    public int attack() {
        Random r = new Random();
        return r.nextInt((mediumMaxAttack-10) + 10);        
    }

    public int giveEXP(){
        return 30;
    }
}
