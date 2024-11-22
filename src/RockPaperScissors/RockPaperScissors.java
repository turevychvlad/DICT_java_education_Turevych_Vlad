package RockPaperScissors;

import java.io.*;
import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Map<String, Integer> ratings = new HashMap<>();

        // Завантаження рейтингу
        try {
            File file = new File("rating.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                int score = fileScanner.nextInt();
                ratings.put(name, score);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No rating file found. Starting fresh.");
        }

        // Ім'я користувача
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName);
        int userScore = ratings.getOrDefault(userName, 0);

        // Вибір режиму гри
        System.out.println("Choose game mode: ");
        System.out.println("1. Classic (rock, paper, scissors)");
        System.out.println("2. Extended (rock, fire, scissors, snake, human, tree, wolf, sponge, paper, air, water, dragon, devil, lightning, gun)");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) break;
                System.out.println("Invalid choice. Please enter 1 or 2.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        String[] options = choice == 1
                ? new String[]{"rock", "paper", "scissors"}
                : new String[]{"rock", "fire", "scissors", "snake", "human", "tree", "wolf", "sponge",
                "paper", "air", "water", "dragon", "devil", "lightning", "gun"};

        System.out.println("Okay, let's start!");

        // Ігровий цикл
        while (true) {
            String userMove = scanner.nextLine();

            if (userMove.equals("!exit")) {
                System.out.println("Bye!");
                ratings.put(userName, userScore);
                saveRatings(ratings);
                break;
            }

            if (userMove.equals("!rating")) {
                System.out.println("Your rating: " + userScore);
                continue;
            }

            if (!Arrays.asList(options).contains(userMove)) {
                System.out.println("Invalid input");
                continue;
            }

            String computerMove = options[random.nextInt(options.length)];
            List<String> winList = getWinningOptions(options, userMove);

            if (userMove.equals(computerMove)) {
                System.out.println("There is a draw (" + computerMove + ")");
                userScore += 50;
            } else if (winList.contains(computerMove)) {
                System.out.println("Sorry, but the computer chose " + computerMove);
            } else {
                System.out.println("Well done. The computer chose " + computerMove + " and failed");
                userScore += 100;
            }
        }
    }

    // Метод для отримання виграшних опцій
    private static List<String> getWinningOptions(String[] options, String userMove) {
        int index = Arrays.asList(options).indexOf(userMove);
        int half = options.length / 2;
        List<String> extendedOptions = new ArrayList<>(Arrays.asList(options));
        Collections.rotate(extendedOptions, -index - 1);

        return extendedOptions.subList(1, half + 1); // Перші "половина" опцій - виграшні
    }

    // Метод для запису рейтингу у файл
    private static void saveRatings(Map<String, Integer> ratings) {
        try (PrintWriter writer = new PrintWriter("rating.txt")) {
            for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving ratings.");
        }
    }
}
