package Monsters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EasyMonster extends Enemy {
    private int easyMaxAttack;
    
    public EasyMonster(int life){
        super(life);
        this.easyMaxAttack = 15;
    }

    @Override
    public int attack() {
        Random r = new Random();
        return r.nextInt(easyMaxAttack-1) + 1;        
    }

    public int giveEXP(){
        return 10;
    }

    public String showMonsterLife(){
        List <String> monsterLife = new ArrayList<String>(10);

        int currLife = (int)(((double)this.getLife()/(double)50) * 10.0f);
         for(int i=0; i<10; i++){
             if(i < Math.ceil(currLife)){
                monsterLife.add("■");
            }else{
                monsterLife.add(" ");
            }
        }

        String z = String.join("", monsterLife);
        String x = "    [" + z + "]";
        return x;
    }

}
