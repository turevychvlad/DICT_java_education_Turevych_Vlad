package RockPaperScissors;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (rock, paper, scissors):");

        while (true) {
            String userMove = scanner.nextLine();

            if (userMove.equalsIgnoreCase("rock")) {
                System.out.println("Sorry, but the computer chose paper");
            } else if (userMove.equalsIgnoreCase("paper")) {
                System.out.println("Sorry, but the computer chose scissors");
            } else if (userMove.equalsIgnoreCase("scissors")) {
                System.out.println("Sorry, but the computer chose rock");
            } else {
                System.out.println("Invalid input. Please enter rock, paper, or scissors.");
            }
        }
    }
}
