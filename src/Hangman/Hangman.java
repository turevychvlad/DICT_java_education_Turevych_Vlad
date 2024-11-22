package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String word = words[random.nextInt(words.length)];
        char[] progress = "-".repeat(word.length()).toCharArray();
        int attempts = 8;

        System.out.println("HANGMAN");
        while (attempts > 0) {
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
                attempts--;
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
