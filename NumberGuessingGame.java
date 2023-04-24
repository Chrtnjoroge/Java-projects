// This is a number guessing game.
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        do {
            Random rand = new Random();
            int range = 0;
            int trials = 0;

            // Asking the user to choose a difficulty level
            System.out.println("Choose a difficulty level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-150)");
            int level = scanner.nextInt();

            // Setting the range of numbers based on the level chosen
            if (level == 1) {
                range = 50;
            } else if (level == 2) {
                range = 100;
            } else if (level == 3) {
                range = 150;
            } else {
                System.out.println("Invalid level chosen. Defaulting to easy level.");
                range = 50;
            }

            int randomNumber = rand.nextInt(range) + 1;

            // Asking the user to input their guesses
            while (true) {
                System.out.println("Input any number from 1-" + range + ":");
                int guess = scanner.nextInt();
                trials++;

                if (guess == randomNumber) {
                    System.out.println("You guessed correctly! You win!");
                    System.out.println("You guessed " + trials + " times.");
                    break;
                } else if (randomNumber > guess) {
                    System.out.println("The number is higher. Guess again.");
                } else if (randomNumber < guess) {
                    System.out.println("The number is lower. Guess again.");
                }
            }

            // Asking the user if they want to play again
            System.out.println("Do you want to play again? (yes(y)/no(n))");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }

        } while (playAgain);

        scanner.close();
    }
}
