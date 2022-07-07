package Monsters;
import java.util.Random;


public class Enemy {
    private int life;
    private int maxAttack;

    public Enemy(){}

    public Enemy(int life) {
        this.life = life;
        this.maxAttack = 50;
    }

    public int getLife() {
        return life;
    }

    public int getMaxAttack(){
        return this.maxAttack;
    }
    
    public void getAttacked(int damage) {
        this.life = life - damage;        
    }

    public int attack() {
        Random r = new Random();
        return r.nextInt((maxAttack-1) + 1);        
    }

    public int giveEXP(){
        return 10;
    }
    
}
