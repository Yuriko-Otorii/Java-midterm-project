import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Player p = new Player();
        Battle b = new Battle(p);
        
        showWelcome();
        
        Thread.sleep(2000);
        clrscr();

        b.battle();

        clrscr();
        showBye();
        
        Thread.sleep(2000);
        s.close();  
    }

    public static void showWelcome(){
        System.out.println("\n" +
        "#     #\n" + 
        "#  #  #  ######  #        ####    ####   #    #  ######\n" + 
        "#  #  #  #       #       #    #  #    #  ##  ##  #\n" + 
        "#  #  #  #####   #       #       #    #  # ## #  #####\n" + 
        "#  #  #  #       #       #       #    #  #    #  #\n" + 
        "#  #  #  #       #       #    #  #    #  #    #  #\n" + 
        " ## ##   ######  ######   ####    ####   #    #  ######\n"
        );
    }

    public static void showBye(){
        System.out.println("\n" + 
        "  ____                   _\n" +
        "|  _ \\                 | |\n" +
        "| |_) |  _   _    ___  | |\n" +
        "|  _ <  | | | |  / _ \\ | |\n" +
        "| |_) | | |_| | |  __/ |_|\n" +
        "|____/   \\__, |  \\___| (_)\n" +
        "          __/ |            \n" +
        "         |___/             \n" );


    }
   



    public static void clrscr(){
		//Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
				System.out.print("\033\143");
		} catch (IOException | InterruptedException ex) {}
	}
}
