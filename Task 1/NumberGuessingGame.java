import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("Round " + (rounds + 1));
            System.out.println("You have " + maxAttempts + " attempts to guess the number between " + lowerBound + " and " + upperBound + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Try a higher number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct number was " + numberToGuess + ".");
                    break;
                }
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }

            rounds++;
        }
    }
}
