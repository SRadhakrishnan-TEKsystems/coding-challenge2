package coding.challenge2.game;

import java.util.Scanner;

public class CLIGame extends Game {
    private Scanner scanner = new Scanner(System.in);
    int userInput = 0;
    String countryName="";

    private CLIGame() {
        playGame();
    }

    public static Game getInstance() {
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

            quit = cliLoop(userInput, countryName,quit);
        }
        return quit;
    }

    @Override
    public boolean cliLoop(int userInput, String countryName, boolean quit) {
        if (userInput == 1) {
            System.out.println("You entered 1");
            System.out.println(promptForCountryName());
            countryName=readCountryName();
            System.out.println(countryName);
        } else if (userInput == 2) {
            quit = true;
            System.out.println("Good Bye!");
        } else System.out.println("Not a valid Entry");
        return quit;
    }

    private String readCountryName() {
        String countryInput = "";
        if (scanner.hasNext()) {
            countryInput = scanner.nextLine();
        }
        return countryInput;

    }

    private String promptForCountryName() {
        return "Please enter the full name of the country";
    }

}
