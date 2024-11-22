package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String word = words[random.nextInt(words.length)];
        String hint = word.substring(0, 2) + "-".repeat(word.length() - 2);
        System.out.println("HANGMAN");
        System.out.println("Guess the word " + hint + ": >");
        String guess = scanner.nextLine();
        if (guess.equals(word)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
