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
        var ref = new Object() {
            int userScore = ratings.getOrDefault(userName, 0);
        };

        // Головний цикл
        label:
        while (true) {
            System.out.println("Main menu:");
            System.out.println("1. Play Classic (rock, paper, scissors)");
            System.out.println("2. Play Extended (rock, fire, scissors, snake, human, tree, wolf, sponge, paper, air, water, dragon, devil, lightning, gun)");
            System.out.println("!rating - View your rating");
            System.out.println("!exit - Exit the game");
            System.out.println("Enter your choice:");

            String choice = scanner.nextLine();

            switch (choice) {
                case "!rating":
                    System.out.println("Your rating: " + ref.userScore);
                    break;
                case "!exit":
                    System.out.println("Bye!");
                    ratings.put(userName, ref.userScore);
                    saveRatings(ratings);
                    break label;
                case "1":
                case "2":
                    String[] options = choice.equals("1")
                            ? new String[]{"rock", "paper", "scissors"}
                            : new String[]{"rock", "fire", "scissors", "snake", "human", "tree", "wolf", "sponge",
                            "paper", "air", "water", "dragon", "devil", "lightning", "gun"};

                    System.out.println("Starting game...");
                    playGame(scanner, random, options, ref.userScore, (score) -> ref.userScore = score);
                    break;
                default:
                    System.out.println("Invalid input. Please select a valid option.");
                    break;
            }
        }
    }

    // Метод гри
    private static void playGame(Scanner scanner, Random random, String[] options, int userScore, ScoreUpdater updater) {
        System.out.println("Enter your move (" + String.join(", ", options) + "), or !exit to return to main menu:");
        while (true) {
            String userMove = scanner.nextLine();

            if (userMove.equals("!exit")) {
                System.out.println("Returning to main menu...");
                break;
            }

            if (!Arrays.asList(options).contains(userMove)) {
                System.out.println("Invalid input. Please try again.");
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
        updater.updateScore(userScore);
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

    // Інтерфейс для оновлення рахунку
    interface ScoreUpdater {
        void updateScore(int score);
    }
}
