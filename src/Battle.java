import java.util.Scanner;
import Monsters.EasyMonster;
import Monsters.Enemy;
import Monsters.HardMonster;
import Monsters.MediumMonster;

public class Battle {
    Player p;
    Enemy m;
    char level;
    public int settingLife;
    public boolean status1 = true;
    public boolean status2 = true;
    public boolean status3 = true;

    public Battle(Player p) {
        this.p = p;
    }

    void battle() throws InterruptedException{
        Scanner s = new Scanner(System.in);
    
        while(status1){
            status2 = true;
            status3 = true;
            settingLife = p.setLifeByLevel();
            p.setPotion(2);

            //Level select feild
            while(status2){
                Thread.sleep(1000);
                App.clrscr();
                System.out.println("\n__________________________________________\n");
                System.out.println("        Choose the monster level  ");
                System.out.println("――――――――――――――――――――――――――――――――――――――――――");
                System.out.println("|                                        |");
                System.out.println("|              A: Easy                   |");
                System.out.println("|              B: Medium                 |");
                System.out.println("|              C: HARD                   |");
                System.out.println("|              D: QUIT                   |");
                System.out.println("|                                        |");
                System.out.println("――――――――――――――――――――――――――――――――――――――――――\n");

                System.out.print("\nPlease type one of the options here: ");

                level = s.next().charAt(0);
                Thread.sleep(1000);
                loading();
                Thread.sleep(1500);
                App.clrscr();
                monsterInstanciate();
            }

            Thread.sleep(2000);
            App.clrscr();

            //Battle field
            char option;        
            while (status3) {
                App.clrscr();

                System.out.println("__________________________________________\n");
                System.out.println("     Your life: " + p.getLife() + "    Monster Life: " + m.getLife());
                System.out.println(p.showPlayerLife(settingLife) + m.showMonsterLife());
                
                System.out.println("     Your level: " + p.getPlayerLevel());
                System.out.println("     Your EXP: " + p.getEXP());
                System.out.println("__________________________________________");
                System.out.println("__________________________________________\n");
                
                System.out.println("            Choose battle option     ");
                System.out.println("__________________________________________");
                System.out.println("|                                        |");
                System.out.println("|              A: Attack                 |");
                System.out.println("|              B: Defense                |");
                System.out.println("|              C: Heal                   |");
                System.out.println("|              D: Run away               |");
                System.out.println("|                                        |");
                System.out.println("――――――――――――――――――――――――――――――――――――――――――\n");
        
                System.out.print("\nPlease type one of the options here: ");

                option = s.next().charAt(0);
                Thread.sleep(1000);
                App.clrscr();
    
                switch (Character.toLowerCase(option)) { 
                    //Attack
                    case 'a':
                        switchCaseAttack();
                        break;
                    
                    //Defense
                    case 'b':
                        switchCaseDefence();
                        break;

                    //Heal
                    case 'c':
                        if(p.getLife() == settingLife){
                            System.out.println("\nYour life is maximum.");
                            Thread.sleep(2000);
                            break;
                        }else{
                            if(p.getPotion() > 0){
                                switchCaseHeal1();
                                break;
                            }else{
                                switchCaseHeal2();
                                break;
                            }
                        }
                            
                    //Run away
                    case 'd':
                        App.clrscr();
                        System.out.println("\nYou ran away from the battle. Please try again.");
                        Thread.sleep(2000);
                        status3 = false;
                        break;
                
                    default:
                        App.clrscr();
                        System.out.println("\nInvalid option. Please try again.");
                        Thread.sleep(2500);
                        break;
                
                    }
                }
            }
    s.close();
    }




    //All methods for battle field.


    void monsterInstanciate() throws InterruptedException {
        switch (Character.toLowerCase(level)) {
            case 'a':
                m = new EasyMonster(50);
                Thread.sleep(1000);
                System.out.println("\n****************************");
                System.out.println("*     ESAY mode starts!    *");
                System.out.println("****************************");
                status2 = false;                   
                break;

            case 'b':
                m = new MediumMonster(100);
                Thread.sleep(1000);
                System.out.println("\n****************************");
                System.out.println("*    MEDIUM mode starts!   *");
                System.out.println("****************************");
                status2 = false;                    
                break;

            case 'c':
                m = new HardMonster(150);
                Thread.sleep(1000);
                System.out.println("\n****************************");
                System.out.println("*     HARD mode starts!    *");
                System.out.println("****************************");
                status2 = false;
                break;
                
                case 'd':
                    App.clrscr();
                    status2 = false;
                    status3 = false;
                    status1 =false;
                    break;

            default:
                System.out.println("\nInvalid option. Please try again.");
                Thread.sleep(2500);
                break;
        }  
    }
    

    void switchCaseAttack() throws InterruptedException {
        int playerAttack = p.attack();
        int monsterAttack =  m.attack();
        boolean switchAstatus = true;

        while(switchAstatus){
            System.out.println("\n** Your turn **");
            System.out.println("You attacked " + playerAttack + "!\n");
            Thread.sleep(2500);
            
            m.getAttacked(playerAttack);
            checkMonsterLife();
            if(status3 == false){
                switchAstatus = false;
                break;
            }          
            Thread.sleep(1000);
    
            System.out.println("\n** Monster turn **");
            System.out.println("Monster atacked " + monsterAttack + "!\n");
            Thread.sleep(2500);
            
            p.getAttacked(monsterAttack);
            checkPlayerLife();
            if(status3 == false){
                switchAstatus = false;
                break;
            }

            // Thread.sleep(1000);
            break;

        }
    }

    void checkMonsterLife() throws InterruptedException{
        if(m.getLife() <= 0){
            int gotEXP =  m.giveEXP();
            App.clrscr();
            System.out.println("\nMonster life is 0.");
            Thread.sleep(3500);
            App.clrscr();
            showWinMessage();
            Thread.sleep(3500);
            App.clrscr();
            System.out.println("You got " + gotEXP + " EXP.");
            p.addEXP(gotEXP);
            p.levelUp();
            Thread.sleep(3000);
            status3 = false;
        }
    }
    
    void checkPlayerLife() throws InterruptedException{
        if(p.getLife() <= 0){
            App.clrscr();
            System.out.println("\nYour life is 0.");
            Thread.sleep(3500);
            App.clrscr();
            showLoseMessage();
            Thread.sleep(3000); 
            status3 = false;
        }
    }



    void switchCaseDefence() throws InterruptedException {
        int monsterAttackCaseB =  m.attack();
        
        System.out.println("\n** Your turn **");
        System.out.println("You set your shield.\n");

        Thread.sleep(2000);

        System.out.println("\n** Monster turn **");
        System.out.println("Monster attacked " + monsterAttackCaseB + "!");
        Thread.sleep(2000);
        System.out.println("\nBut it is decreased by " + monsterAttackCaseB/2 + "!\n");
        Thread.sleep(2000);
    }

    void switchCaseHeal1() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int lifeAfterPotion;
        boolean potionStatus = true;

        System.out.println("\nYour life is " + p.getLife() + ".");
        Thread.sleep(1000);
        System.out.println("And you have " + p.getPotion() +  " potions.");
        while(potionStatus){
            Thread.sleep(1500);
            System.out.print("\nDo you want to use 1 potion? Y/N: ");
            char answer = s.next().charAt(0);
            App.clrscr();
            Thread.sleep(1000);

            switch (Character.toLowerCase(answer)) {
                case 'y':        
                    Thread.sleep(1500);                      
                    if(p.getLife() == settingLife){
                        System.out.println("\nYour life is maximum.");
                        Thread.sleep(2000);
                        potionStatus = false;
                        break;
                    }
                    if(p.getPotion() == 0){
                        System.out.println("\nYou do not have potions.");
                        Thread.sleep(2000);
                        potionStatus = false;
                        break;
                    }

                    App.clrscr();
                    System.out.println("\nYou used your potion.");
                    lifeAfterPotion = p.lifeAfterPotion(25);
                    p.potionDecrement();
                    if(p.getLife() > settingLife){
                        p.setLifeByLevel();
                    }

                    Thread.sleep(2000);
                    System.out.print("\nNow your life is " + p.getLife() + ".");
                    if(p.getLife() == settingLife){
                        System.out.println("(Maximum life)");
                    }
                    Thread.sleep(2000);

                    if(p.getPotion() <= 0){
                        System.out.println("\nAnd you used all potions.");
                        Thread.sleep(2000);
                        potionStatus = false;
                        break;
                    }else{
                        System.out.println("\nYour potion is " + p.getPotion() + " reft.");
                        Thread.sleep(2500);
                        potionStatus = false;
                        break;
                    }
                
                case 'n':
                    System.out.println("\nYou did not use your potion.");
                    Thread.sleep(1500);
                    potionStatus = false;
                    break;
            
                default:
                    App.clrscr();
                    System.out.println("\nInvalid option. Please try again.");
                    Thread.sleep(2500);
                    App.clrscr();
                    break;
            }  
        }
    }
    
    void switchCaseHeal2() throws InterruptedException {
        boolean potionStatus = true;
        Thread.sleep(1500);
        System.out.println("\nYou do not have any potion.");
        Thread.sleep(1500);
        potionStatus = false;
    }


    void loading() throws InterruptedException {
        App.clrscr();
        System.out.println("\n----------------Loading----------------");
        Thread.sleep(1000);
    }
    


    public void showWinMessage(){
        System.out.println("\n" +
        " __   __   ___    _   _    __        __  ___   _   _\n" +
        " \\ \\ / /  / _ \\  | | | |   \\ \\      / / |_ _| | \\ | |\n" +
        "  \\ V /  | | | | | | | |    \\ \\ /\\ / /   | |  |  \\| |\n" +
        "   | |   | |_| | | |_| |     \\ V  V /    | |  | |\\  |\n" +
        "   |_|    \\___/   \\___/       \\_/\\_/    |___| |_| \\_|\n");
    }
    
    
    public void showLoseMessage(){
        System.out.println("\n" + 
        "__   __  ___   _   _   _       ___   ____   _____\n" + 
        "\\ \\ / / / _ \\ | | | | | |     / _ \\ / ___| | ____|\n" + 
        " \\ V / | | | || | | | | |    | | | |\\___ \\ |  _|\n" + 
        "  | |  | |_| || |_| | | |___ | |_| | ___) || |___\n" + 
        "  |_|   \\___/  \\___/  |_____| \\___/ |____/ |_____|\n" );
    }



}


