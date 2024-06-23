import java.util.Random;
import java.util.Scanner;

public class numberguessinggame {

    // Generate a random number within a specified range
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    // Play a single round of the game
    public static boolean playGame(Scanner scanner) {
        int randomNumber = generateRandomNumber(1, 100);
        int attempts = 0;
        final int maxAttempts = 10;
        boolean isCorrect = false;

        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            // Validate user input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
                continue;
            }
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                isCorrect = true;
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        if (!isCorrect) {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
        }

        return isCorrect;
    }

    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        while (true) {
            rounds++;
            System.out.println("\n--- Round " + rounds + " ---");
            if (playGame(scanner)) {
                score++;
            }

            // Option for multiple rounds
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display the user's score
        System.out.println("\nGame Over! You played " + rounds + " rounds and won " + score + " of them.");
        scanner.close();
    }
}

