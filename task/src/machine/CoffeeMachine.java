package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int INITIAL_WATER = 400;
    static final int INITIAL_MILK = 540;
    static final int INITIAL_BEANS = 120;
    static final int INITIAL_CUPS = 9;
    static final int INITIAL_MONEY = 550;

    static final int ESPRESSO_WATER = 250;
    static final int ESPRESSO_MILK = 0;
    static final int ESPRESSO_BEANS = 16;
    static final int ESPRESSO_PRICE = 4;

    static final int LATTE_WATER = 350;
    static final int LATTE_MILK = 75;
    static final int LATTE_BEANS = 20;
    static final int LATTE_PRICE = 7;

    static final int CAPPUCCINO_WATER = 200;
    static final int CAPPUCCINO_MILK = 100;
    static final int CAPPUCCINO_BEANS = 12;
    static final int CAPPUCCINO_PRICE = 6;

    static int water = INITIAL_WATER;
    static int milk = INITIAL_MILK;
    static int beans = INITIAL_BEANS;
    static int cups = INITIAL_CUPS;
    static int money = INITIAL_MONEY;

    static Scanner scanner = new Scanner(System.in);

    static void buyCoffee(int latteWater, int latteMilk, int latteBeans, int lattePrice) {
        if (water < latteWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < latteMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < latteBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            water -= latteWater;
            milk -= latteMilk;
            beans -= latteBeans;
            cups--;
            money += lattePrice;

            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    static void buyEspresso() {
        buyCoffee(ESPRESSO_WATER, ESPRESSO_MILK, ESPRESSO_BEANS, ESPRESSO_PRICE);
    }

    static void buyLatte() {
        buyCoffee(LATTE_WATER, LATTE_MILK, LATTE_BEANS, LATTE_PRICE);
    }

    static void buyCappuccino() {
        buyCoffee(CAPPUCCINO_WATER, CAPPUCCINO_MILK, CAPPUCCINO_BEANS, CAPPUCCINO_PRICE);
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String order = scanner.nextLine();
        switch (order) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
        }

        System.out.println();
    }

    static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterToAdd = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        int milkToAdd = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beansToAdd = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsToAdd = Integer.parseInt(scanner.nextLine());

        water += waterToAdd;
        milk += milkToAdd;
        beans += beansToAdd;
        cups += cupsToAdd;
        System.out.println();
    }

    static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
    }

    static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of coffee disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    static void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
            }
        }
    }
}
