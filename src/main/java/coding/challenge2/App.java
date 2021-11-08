package coding.challenge2;

import coding.challenge2.restCountries.CapitalCity;
import coding.challenge2.restCountriesRequest.CapitalCityRequest;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App().playGame();
    }

    private void playGame() {
        boolean quit = false;
        App app = new App();
        while (!quit) {
            quit = isQuit(quit, app);
        }
    }

    private boolean isQuit(boolean quit, App app) {
        int userInput = 0;
        System.out.println("Press 1 to play 2 to quit");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        } else {
            scanner.next();
        }
        if (userInput == 1) {
            System.out.println(app.promptForInput());
            String countryInput = app.readInput();
            CapitalCity capitalCity = CapitalCityRequest.getInstance(countryInput).get();
            app.outputCapitalCity(countryInput, capitalCity);
        } else if (userInput == 2) {
            quit = true;
            scanner.close();
            System.out.println("Okay Bye");
        } else System.out.println("Not a valid Entry");
        return quit;
    }

    private void outputCapitalCity(String countryInput, CapitalCity capitalCity) {
        String country = capitalizeEachWord(countryInput);

        String output;
        output = capitalCity != null ? "The capital city of " + country + " is " + capitalCity : "Invalid name for country";
        System.out.println(output);
    }

    private String capitalizeEachWord(String str) {
        if(str == null || str.length() == 0)
            return "";
        if(str.length() == 1)
            return str.toUpperCase();
        String[] words = str.split(" ");
        StringBuilder sbCapitalizedWords = new StringBuilder(str.length());
        for(String word : words){

            if(word.length() > 1)
                sbCapitalizedWords
                        .append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase());
            else
                sbCapitalizedWords.append(word.toUpperCase());

            sbCapitalizedWords.append(" ");
        }
        return sbCapitalizedWords.toString().trim();
    }

    public String promptForInput() {
        return "Please enter the full name of the country";
    }

    String readInput() {
        String countryInput = "";
        if (scanner.hasNext()) {
            countryInput = scanner.nextLine();
        }
        return countryInput;
    }

}
