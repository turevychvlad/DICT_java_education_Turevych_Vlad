package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int waterNeeded = cups * 200;
        int milkNeeded = cups * 50;
        int beansNeeded = cups * 15;

        int maxCups = Math.min(waterAvailable / 200, Math.min(milkAvailable / 50, beansAvailable / 15));

        if (waterAvailable >= waterNeeded && milkAvailable >= milkNeeded && beansAvailable >= beansNeeded) {
            if (maxCups == cups) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }
}
