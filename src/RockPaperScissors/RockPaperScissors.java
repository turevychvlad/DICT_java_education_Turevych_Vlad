package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"rock", "paper", "scissors"};

        System.out.println("Enter your move (rock, paper, scissors) or !exit to quit:");
        while (true) {
            String userMove = scanner.nextLine();

            if (userMove.equals("!exit")) {
                System.out.println("Bye!");
                break;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid input. Please enter rock, paper, scissors, or !exit.");
                continue;
            }

            String computerMove = options[random.nextInt(3)];
            if (userMove.equals(computerMove)) {
                System.out.println("There is a draw (" + computerMove + ")");
            } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                    (userMove.equals("scissors") && computerMove.equals("paper")) ||
                    (userMove.equals("paper") && computerMove.equals("rock"))) {
                System.out.println("Well done. The computer chose " + computerMove + " and failed");
            } else {
                System.out.println("Sorry, but the computer chose " + computerMove);
            }
        }
    }
}
