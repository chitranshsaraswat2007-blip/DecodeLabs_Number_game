package decodelabs;
import java.util.*;

public class Project1_THe_NUmber_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;
        final int MAX_ATTEMPTS = 7;

        System.out.println("=================================");
        System.out.println("   WELCOME TO THE NUMBER GAME");
        System.out.println("   DecodeLabs Java Project 1");
        System.out.println("=================================");

        do {

            int target = random.nextInt(100) + 1;
            int attemptsUsed = 0;
            boolean win = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!");


            while (!win && attemptsUsed < MAX_ATTEMPTS) {
                int guess;

                System.out.print("\nAttempt " + (attemptsUsed + 1) + "/" + MAX_ATTEMPTS + " - Enter your guess: ");
                System.out.flush();

                try {
                    guess = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid whole number. Please try again.");
                    sc.nextLine();
                    continue;
                }

                attemptsUsed++;

                if (guess == target) {
                    win = true;
                    System.out.println("Correct! The number was " + target + ".");
                } else if (guess > target) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Too low! Try a higher number.");
                }
            }

            if (win) {
                int roundScore = (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
                totalScore += roundScore;
                System.out.println("You got it in " + attemptsUsed + " attempt(s)! +" + roundScore + " points.");
            } else {
                System.out.println("Out of attempts! The number was " + target + ".");
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nPlay again? (Y/N): ");
            System.out.flush();
            sc.nextLine();          
            String response = sc.nextLine().trim();
            playAgain = response.isEmpty() ? 'N' : Character.toUpperCase(response.charAt(0));

        } while (playAgain == 'Y');

        System.out.println("\nThanks for playing! Final Score: " + totalScore);
        sc.close();
    }
}
