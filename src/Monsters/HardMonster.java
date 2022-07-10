package Monsters;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class HardMonster extends Enemy {
    private int hardMaxAttack;
    

    public HardMonster(int life) {
        super(life);
        this.hardMaxAttack = 60;
    }

    @Override
    public int attack() {
        Random r = new Random();
        return r.nextInt(hardMaxAttack-20) + 20;        
    }

    public int giveEXP(){
        return 60;
    }

    public String showMonsterLife(){
        List <String> monsterLife = new ArrayList<String>(10);

        int currLife = (int)(((double)this.getLife()/(double)150) * 10.0f);
         for(int i=0; i<10; i++){
             if(i < currLife){
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
