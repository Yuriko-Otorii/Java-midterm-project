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
            return r.nextInt((80-50) + 50);
        }else if(this.playerLevel > 4){
            return r.nextInt((60-30) + 30);
        }else if(this. playerLevel > 2){
            return r.nextInt((40-15) + 15);
        }else{
            return r.nextInt((30-1) + 1);
        }
    }

    public void getAttacked(int damage) {
        this.life = life - damage;
    }

    public void usePotion(){
        this.life = life + 25;
        this.potion = potion - 1;
    }

    public void addEXP(int EXP){
        this.EXP = this.EXP + EXP;
    }

    public void levelUp() throws InterruptedException{
        if(this.EXP == this.leveUpPoint){
            Thread.sleep(3500);
            App.clrscr();
            showLevelUp();
            Thread.sleep(2500);
            App.clrscr();
            this.playerLevel++;
            this.leveUpPoint = this.leveUpPoint + (this.leveUpPoint*2);
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



}




