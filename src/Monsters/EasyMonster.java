package Monsters;
import java.util.Random;

public class EasyMonster extends Enemy {
    private int easyMaxAttack;
    
    public EasyMonster(int life){
        super(life);
        this.easyMaxAttack = 20;
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
        return r.nextInt((easyMaxAttack-1) + 1);        
    }

    public int giveEXP(){
        return 10;
    }

    

}
