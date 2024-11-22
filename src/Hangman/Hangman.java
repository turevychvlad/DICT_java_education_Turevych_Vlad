package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};

        System.out.println("HANGMAN");
        System.out.println("Type \"play\" to play the game, \"exit\" to quit: >");

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("play")) {
                playGame(scanner, random, words);
            } else if (command.equals("exit")) {
                break;
            }
        }
    }

    public static void playGame(Scanner scanner, Random random, String[] words) {
        String word = words[random.nextInt(words.length)];
        char[] progress = "-".repeat(word.length()).toCharArray();
        int mistakes = 0;
        int maxMistakes = 8;

        while (mistakes < maxMistakes) {
            System.out.println(progress);
            System.out.println("Input a letter: >");
            char guess = scanner.next().charAt(0);

            if (word.indexOf(guess) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        progress[i] = guess;
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                mistakes++;
            }

            if (String.valueOf(progress).equals(word)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                return;
            }
        }
        System.out.println("You lost!");
    }
}
