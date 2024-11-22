package Hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("HANGMAN");
            System.out.println("Type \"play\" to play the game, \"exit\" to quit:");
            String command = scanner.nextLine().trim(); // Забираємо зайві пробіли та символи нового рядка

            if (command.equals("play")) {
                playGame(scanner); // Запуск гри
            } else if (command.equals("exit")) {
                break; // Завершення програми
            } else {
                System.out.println("Invalid command. Please type \"play\" or \"exit\".");
            }
        }
    }

    public static void playGame(Scanner scanner) {
        Random random = new Random();
        String[] words = {"python", "java", "javascript", "kotlin"};
        String word = words[random.nextInt(words.length)];
        char[] progress = "-".repeat(word.length()).toCharArray();
        int mistakes = 0;
        int maxMistakes = 8;
        boolean[] guessedLetters = new boolean[26];

        System.out.println("Starting the game...");
        while (mistakes < maxMistakes) {
            System.out.println(String.valueOf(progress));
            System.out.println("Input a letter:");
            String input = scanner.next().trim();

            // Перевірка введення
            if (input.length() != 1) {
                System.out.println("You should input a single letter.");
                continue;
            }
            char guess = input.charAt(0);
            if (!Character.isLowerCase(guess)) {
                System.out.println("Please enter a lowercase English letter.");
                continue;
            }
            if (guessedLetters[guess - 'a']) {
                System.out.println("You've already guessed this letter.");
                continue;
            }
            guessedLetters[guess - 'a'] = true;

            if (word.indexOf(guess) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        progress[i] = guess;
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word.");
                mistakes++;
            }

            if (String.valueOf(progress).equals(word)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                scanner.nextLine(); // Очищення потоку після завершення гри
                return;
            }
        }
        System.out.println("You lost!");
        scanner.nextLine(); // Очищення потоку після завершення гри
    }
}
