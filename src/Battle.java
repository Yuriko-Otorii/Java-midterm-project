import java.util.Scanner;
import Monsters.EasyMonster;
import Monsters.Enemy;
import Monsters.HardMonster;
import Monsters.MediumMonster;

public class Battle {
    Player p;
    Enemy m;
    char level;
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
                
                monsterInstanciate();
            }

            Thread.sleep(2000);
            App.clrscr();

            //Battle field
            char option;        
            while (status3) {

                setLife();
                Thread.sleep(1000);
                App.clrscr();

                System.out.println("__________________________________________\n");
                System.out.println("     Your life: " + p.getLife() + "    Monster Life: " + m.getLife());
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
                loading();
    
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
                        App.clrscr();
                        if(p.getPotion() > 0){
                            System.out.println("\nYou have " + p.getPotion() +  " potions.");
                            Thread.sleep(1000);
                            System.out.print("\nDo you want to use 1 potion? Y/N: ");
                            char answer = s.next().charAt(0);
                            if(Character.toLowerCase(answer) == 'y'){
                                if(p.getPotion() <= 0){
                                    System.out.println("\nYou do not have potions.");
                                    Thread.sleep(2000);
                                    break;
                                }
                                App.clrscr();
                                Thread.sleep(1000);
                                System.out.println("\nYou used your potion.");
                                p.usePotion();
                                Thread.sleep(2000);
                                if(p.getPotion() <= 0){
                                    System.out.println("\nYou used all potions.");
                                    Thread.sleep(2000);
                                    break;
                                }else{
                                    App.clrscr();
                                    System.out.println("\nNow your life is " + p.getLife() + ".\n");
                                    Thread.sleep(1500);
                                    System.out.println("And your potion is " + p.getPotion() + " reft.");
                                    Thread.sleep(2000);
                                    break;
                                }
                            }else{
                                System.out.println("\nYou did not use your potion.");
                                Thread.sleep(1500);
                                break;
                            }
                        }else{
                            System.out.println("You do not have any potion.");
                            Thread.sleep(1500);
                            break;
                        }
                    
                    //Run away
                    case 'd':
                        App.clrscr();
                        System.out.println("\nYou ran away from the battle. Please try again.");
                        Thread.sleep(1000);
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
                App.clrscr();
                m = new EasyMonster(20);
                Thread.sleep(1000);
                System.out.println("\n*************************");
                System.out.println("*   ESAY mode starts!  *");
                System.out.println("*************************");
                status2 = false;                   
                break;

            case 'b':
                App.clrscr();  
                m = new MediumMonster(100);
                Thread.sleep(1000);
                System.out.println("\n*************************");
                System.out.println("*  MEDIUM mode starts!  *");
                System.out.println("*************************");
                status2 = false;                    
                break;

            case 'c':
                App.clrscr();
                m = new HardMonster(150);
                Thread.sleep(1000);
                System.out.println("\n*************************");
                System.out.println("*   HARD mode starts!  *");
                System.out.println("*************************");
                status2 = false;
                break;
                
                case 'd':
                    App.clrscr();
                    status2 = false;
                    status3 = false;
                    status1 =false;
                    break;

            default:
                App.clrscr();
                System.out.println("\nInvalid option. Please try again.");
                Thread.sleep(2500);
                break;
        }  
    }
    



    void switchCaseAttack() throws InterruptedException {
        App.clrscr();
        int playerAttack = p.attack(); 
        int monsterAttack =  m.attack();
        boolean switchAstatus = true;

        while(switchAstatus){
            System.out.println("\n** Your turn **");
            System.out.println("You attacked " + playerAttack + "!\n");
            Thread.sleep(2500);
            
            //Showing "Critical hit"
            if(playerAttack > 45){
                System.out.println("\nCritical hit!!");
            }
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
            //Showing "Critical hit"
            if(Math.abs(monsterAttack) < Math.abs(m.getMaxAttack() * (90/100))){
                System.out.println("\nCritical hit!!");
            }
            p.getAttacked(monsterAttack);
            checkPlayerLife();
            if(status3 == false){
                switchAstatus = false;
                break;
            }

            Thread.sleep(1500);
            break;

        }
    }

    void checkMonsterLife() throws InterruptedException{
        if(m.getLife() < 0){
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
        if(p.getLife() < 0){
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
        App.clrscr();
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



    void setLife(){
        if(p.getPlayerLevel() > 6){
            p.setLife(200);
        }else if(p.getPlayerLevel() > 4){
            p.setLife(150);
        }else if(p.getPlayerLevel() >= 2){
            p.setLife(100);
        }else{
            p.setLife(50);

        }
    }


    // void switchCaseHeal() throws InterruptedException {
    //     Scanner s = new Scanner(System.in);

    //     App.clrscr();
    //     if(p.getPotion() > 0){
    //         System.out.println("\nYou have " + p.getPotion() +  " potions.");
    //         Thread.sleep(1000);
    //         System.out.print("\nDo you want to use 1 potion? Y/N: ");
    //         char answer = s.next().charAt(0);
    //         if(Character.toLowerCase(answer) == 'y'){
    //             if(p.getPotion() <= 0){
    //                 System.out.println("\nYou do not have potions.");
    //                 Thread.sleep(2000);
    //                 break;
    //             }
    //             App.clrscr();
    //             Thread.sleep(1000);
    //             System.out.println("\nYou used your potion.");
    //             p.usePotion();
    //             Thread.sleep(2000);
    //             if(p.getPotion() <= 0){
    //                 System.out.println("\nYou used all potions.");
    //                 Thread.sleep(2000);
    //                 break;
    //             }else{
    //                 App.clrscr();
    //                 System.out.println("\nNow your life is " + p.getLife() + ".\n");
    //                 Thread.sleep(1500);
    //                 System.out.println("And your potion is " + p.getPotion() + " reft.");
    //                 Thread.sleep(2000);
    //                 break;
    //             }
    //         }else{
    //             System.out.println("\nYou did not use your potion.");
    //             Thread.sleep(1500);
    //             break;
    //         }
    //     }else{
    //         System.out.println("You do not have any potion.");
    //         Thread.sleep(1500);
    //         break;
    //     }
    // }


    

   




    void loading() throws InterruptedException {
        App.clrscr();
        System.out.println("\n----------------Loading----------------");
        Thread.sleep(2000);
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


