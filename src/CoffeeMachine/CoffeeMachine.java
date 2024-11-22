package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400, milk = 540, beans = 120, cups = 9, money = 550;

        label:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = scanner.next();
                    switch (choice) {
                        case "1" -> {
                            if (water >= 250 && beans >= 16 && cups >= 1) {
                                water -= 250;
                                beans -= 16;
                                cups--;
                                money += 4;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }
                        }
                        case "2" -> {
                            if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups--;
                                money += 7;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }
                        }
                        case "3" -> {
                            if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups--;
                                money += 6;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println("Sorry, not enough resources!");
                            }
                        }
                        case "back" -> {
                            continue;
                        }
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    cups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " ml of water");
                    System.out.println(milk + " ml of milk");
                    System.out.println(beans + " g of coffee beans");
                    System.out.println(cups + " disposable cups");
                    System.out.println("$" + money + " of money");
                    break;
                case "exit":
                    break label;
            }
        }
    }
}
