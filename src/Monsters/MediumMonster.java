package Monsters;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MediumMonster extends Enemy {
    private int mediumMaxAttack;
    

    public MediumMonster(int life) {
        super(life);
        this.mediumMaxAttack = 40;
    }

    @Override
    public int attack() {
        Random r = new Random();
        return r.nextInt(mediumMaxAttack-10) + 10;        
    }

    public int giveEXP(){
        return 30;
    }

    public String showMonsterLife(){
        List <String> monsterLife = new ArrayList<String>(10);

        int currLife = (int)(((double)this.getLife()/(double)100) * 10.0f);
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
