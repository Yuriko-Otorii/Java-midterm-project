package Monsters;
import java.util.Random;


public class HardMonster extends Enemy {
    private int hardMaxAttack;
    

    public HardMonster(int life) {
        super(life);
        this.hardMaxAttack = 60;
    }

    // @Override
    // public int getLife() {
    //     return life;
    // }


    // @Override
    // public void getAttacked(int damage) {
    //     this.life = life - (damage/2);        
    // }


    @Override
    public int attack() {
        Random r = new Random();
        return r.nextInt((hardMaxAttack-20) + 20);        
    }

    public int giveEXP(){
        return 60;
    }
}
