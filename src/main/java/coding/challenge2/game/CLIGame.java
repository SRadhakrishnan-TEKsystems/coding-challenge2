package coding.challenge2.game;

import java.util.Scanner;

public class CLIGame extends Game {
    private Scanner scanner = new Scanner(System.in);
    int userInput = 0;

    private CLIGame() {
        playGame();
    }

        public static Game getInstance () {
            return new CLIGame();
        }

    public boolean playGame() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Press 1 to play 2 to quit");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        } else {
            scanner.next();
        }
            quit = cliLoop(userInput,quit);
        }
        return quit;
  }

        public static boolean cliLoop ( int userInput, boolean quit){
            if (userInput == 1) {
                System.out.println("You entered 1");
            } else if (userInput == 2) {
                quit = true;
                System.out.println("Good Bye!");
            } else System.out.println("Not a valid Entry");
            return quit;
        }

    }
