// public class CopyApp {
//     import java.util.Scanner;

// import Monsters.EasyMonster;
// import Monsters.HardMonster;
// import Monsters.MediumMonster;

// public class Battle {
//     Player p;
//     public boolean status1 = true;
//     public boolean status2 = true;
//     public boolean status3 = true;

//     public Battle(Player p) {
//         this.p = p;
//     }

//     void battle() throws InterruptedException{

//         Scanner s = new Scanner(System.in);
    
//         while(status1){

//         //Level select feild
//         while(status2){
//             Thread.sleep(1000);
//             App.clrscr();
//             System.out.println("-----------------------------------------");
//             System.out.println("      Choose the monster level  ");
//             System.out.println("-----------------------------------------\n");
//             System.out.println("A: Easy");
//             System.out.println("B: Medium");
//             System.out.println("C: Hard");

//             System.out.print("\nPlease type one of the options here: ");
//             char level = s.next().charAt(0);
//             Thread.sleep(1000);
//             loading();
            
//                 switch (Character.toLowerCase(level)) {
//                     case 'a':
//                         App.clrscr();
//                         m = new Monster("easy");
//                         Thread.sleep(1000);
//                         System.out.println("\n*************************");
//                         System.out.println("*   ESAY mode starts!  *");
//                         System.out.println("*************************");
//                         status2 = false;                   
//                         break;
        
//                     case 'b':
//                         App.clrscr();  
//                         m = new Monster("medium");
//                         Thread.sleep(1000);
//                         System.out.println("\n*************************");
//                         System.out.println("*  MEDIUM mode starts!  *");
//                         System.out.println("*************************");
//                         status2 = false;                    
//                         break;
        
//                     case 'c':
//                         App.clrscr();
//                         m = new Monster("hard");
//                         Thread.sleep(1000);
//                         System.out.println("\n*************************");
//                         System.out.println("*   HARD mode starts!  *");
//                         System.out.println("*************************");
//                         status2 = false;
//                         break;
                
//                     default:
//                         App.clrscr();
//                         System.out.println("\nInvalid option. Please try again.");
//                         Thread.sleep(2500);
//                         break;
//                 }        
//         }

//         Thread.sleep(2000);
//         App.clrscr();

//         //Battle field
//         char option;
//         // Player p = new Player();
        
//         while (status3) {
//             Thread.sleep(1000);
//             App.clrscr();

//             System.out.println("-----------------------------------------");
//             System.out.println("         Choose battle option");
//             System.out.println("-----------------------------------------");
    
//             System.out.println("(Your life: " + p.getLife() + "   Monster Life: " + m.getLife() + ")\n");
    
//             System.out.println("A: Attack");
//             System.out.println("B: Protect");
//             System.out.println("C: Heal");
//             System.out.println("D: Run away");
    
//             System.out.print("\nPlease type one of the options here: ");
//             option = s.next().charAt(0);
//             Thread.sleep(1000);
//             loading();
    
//             switch (Character.toLowerCase(option)) { 
//                 case 'a':
//                     App.clrscr();
//                     int playerAttack = p.attack(); 
//                     int monsterAttack =  m.attack();
//                     System.out.println("\n** Your turn **");
//                     System.out.println("You attacked " + playerAttack + "!");
//                     if(playerAttack > 45){
//                         Thread.sleep(1000);
//                         System.out.println("\nCritical hit!!");
//                     }
//                     m.getAttacked(playerAttack);
    
//                     Thread.sleep(2000);
    
//                     System.out.println("\n** Monster turn **");
//                     System.out.println("Monster atacked " + monsterAttack + "!\n");
//                     if(monsterAttack > 45){
//                         Thread.sleep(1000);
//                         System.out.println("\nCritical hit!!");
//                     }
//                     p.getAttacked(monsterAttack);
    
//                     Thread.sleep(1000);
    
//                     if(p.getLife() < 0){
//                         System.out.println("-----------------------------------------");
//                         Thread.sleep(2000);
//                         System.out.println("\nYour life is 0.");
//                         Thread.sleep(2000);
//                         System.out.println("You lose!");
//                         Thread.sleep(2000);
//                         status3 = false;
//                         status1 = false;
//                         break;
//                     }else if(m.getLife() < 0){
//                         System.out.println("-----------------------------------------");
//                         Thread.sleep(2000);
//                         System.out.println("\nMonster life is 0.");
//                         Thread.sleep(2000);
//                         System.out.println("You win!");
//                         Thread.sleep(2000);
//                         status3 = false;
//                         status1 = false;
//                         break;
//                     }
//                     Thread.sleep(1500);
//                     break;
    
//                 case 'b':
//                     App.clrscr();
//                     System.out.println("\n** Your turn **");
//                     System.out.println("You set the shield.");
    
//                     Thread.sleep(2000);
    
//                     System.out.println("\n** Monster turn **");
//                     System.out.println("Monster attacked " + m.attack() + "!");
//                     Thread.sleep(2000);
//                     System.out.println("\nBut it did not work.");
//                     Thread.sleep(2000);
//                     break;
    
//                 case 'c':
//                 App.clrscr();
//                 System.out.println("\nYou have " + p.getPotion() +  " potions.");
//                 Thread.sleep(1000);
//                 System.out.print("\nDo you want to use 1 potion? Y/N: ");
//                 char answer = s.next().charAt(0);
//                 if(Character.toLowerCase(answer) == 'y'){
//                     if(p.getPotion() <= 0){
//                         System.out.println("\nYou do not have potions.");
//                         Thread.sleep(2000);
//                         break;
//                     }
//                     App.clrscr();
//                     Thread.sleep(1000);
//                     System.out.println("\nYou used your potion.");
//                     p.usePotion();
//                     Thread.sleep(2000);
//                         App.clrscr();
//                         System.out.println("\nNow your life is " + p.getLife() + ".\n");
//                         Thread.sleep(1000);
//                         System.out.println("And your potion is " + p.getPotion() + ".");
//                         Thread.sleep(2000);
//                         break;
//                 }else{
//                     System.out.println("\nYou did not use your potion.");
//                     Thread.sleep(1500);
//                     break;
//                 }
                
//                 case 'd':
//                     App.clrscr();
//                     System.out.println("\nYou ran away from the battle. Please try again.");
//                     Thread.sleep(2000);
//                     status3 = false;
//                     break;
            
//                 default:
//                     App.clrscr();
//                     System.out.println("\nInvalid option. Please try again.");
//                     Thread.sleep(2500);
//                     break;
            
//                 }
//             }
//         }
//     s.close();
//     }

// }
