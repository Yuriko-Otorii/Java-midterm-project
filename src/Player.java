import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int potion = 2;
    private int life = 50;
    private int EXP = 0;
    private int playerLevel = 1;
    private int leveUpPoint = 10;


    public Player() {}

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }

    public int getEXP() {
        return EXP;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    int attack(){
        Random r = new Random();
        if(this.playerLevel > 6){
            return r.nextInt(80-50) + 50;
        }else if(this.playerLevel > 4){
            return r.nextInt(60-30) + 30;
        }else if(this. playerLevel > 2){
            return r.nextInt(40-15) + 15;
        }else{
            return r.nextInt(30-1) + 1;
        }
    }

    public void getAttacked(int damage) {
        this.life = this.life - damage;
    }

    public int lifeAfterPotion(int potion){
        this.life = this.life + potion;
        return this.life;
    }

    public void potionDecrement(){
        this.potion--;
    }

    public void addEXP(int EXP){
        this.EXP = this.EXP + EXP;
    }

    public void levelUp() throws InterruptedException{
        if(this.EXP >= this.leveUpPoint){
            Thread.sleep(3500);
            App.clrscr();
            showLevelUp();
            Thread.sleep(2500);
            App.clrscr();
            this.playerLevel++;
            this.leveUpPoint = this.leveUpPoint*2;
            System.out.println(("Now your level is " + playerLevel + "."));
        }
    }

    void showLevelUp(){
        System.out.println("\n" + 
        " _      _____ __     __ _____  _       _   _  ____   _\n" + 
        "| |    | ____|\\ \\   / /| ____|| |     | | | ||  _ \\ | |\n" + 
        "| |    |  _|   \\ \\ / / |  _|  | |     | | | || |_) || |\n" + 
        "| |___ | |___   \\ V /  | |___ | |___  | |_| ||  __/ |_|\n" + 
        "|_____||_____|   \\_/   |_____||_____|  \\___/ |_|    (_)\n");
    }

    public int setLifeByLevel(){
        int settingLife = 0;
        if(this.getPlayerLevel() > 6){
            this.setLife(200);
            settingLife = 200;
        }else if(this.getPlayerLevel() > 4){
            this.setLife(150);
            settingLife = 150;
        }else if(this.getPlayerLevel() >= 2){
            this.setLife(100);
            settingLife = 100;
        }else{
            this.setLife(50);
            settingLife = 50;
        }
        return settingLife;
    }


    public String showPlayerLife(int Life){
        List <String> playerLife = new ArrayList<String>(10); 
        int currLife = (int)(((double)this.getLife()/(double)Life) * 10.0f);
        
         for(int i=0; i<10; i++){
            
             if( i < Math.ceil(currLife) ){
                playerLife.add("■");
            }else{
                playerLife.add(" ");
            }
        }

        

        // if(this.getLife() <= life*.1){
        //     for(int i=0; i < 1; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 9; i++){
        //         playerLife.add(" ");
        //     }            
        // }else if(this.getLife() <= life*.2){
        //     for(int i=0; i < 2; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 8; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.3){
        //     for(int i=0; i < 3; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 7; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.4){
        //     for(int i=0; i < 4; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 6; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.5){
        //     for(int i=0; i < 5; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 5; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.6){
        //     for(int i=0; i < 6; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 4; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.7){
        //     for(int i=0; i < 7; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 3; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.8){
        //     for(int i=0; i < 8; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 2; i++){
        //         playerLife.add(" ");
        //     } 
        // }else if(this.getLife() <= life*.9){
        //     for(int i=0; i < 9; i++){
        //         playerLife.add("■");
        //     }
        //     for(int i=0; i <= 1; i++){
        //         playerLife.add(" ");
        //     } 
        // }else{
        //     for(int i=0; i < 10; i++){
        //         playerLife.add("■");
        //     }
        // }

        String z = String.join("", playerLife);
        String x = "     [" + z + "]";
        return x;
    }



}




