import java.util.Scanner;

public class CoffeeMachineStage3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int amountOfWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int amountOfMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int amountOfCoffee = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();

        calculateAmounts(numberOfCups, calculateDeliverableNumberOfCups(amountOfWater, amountOfMilk, amountOfCoffee));
    }

    //needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans
    private static int calculateDeliverableNumberOfCups(int waterInput, int milkInput, int coffeeBeanInput) {

        int numOfCupsFromGivenWater, numOfCupsFromGivenMilk, numOfCupsFromGivenCoffeeBean, deliverableNumberOfCups;

        numOfCupsFromGivenWater = waterInput / 200;
        numOfCupsFromGivenMilk = milkInput / 50;
        numOfCupsFromGivenCoffeeBean = coffeeBeanInput / 15;
        deliverableNumberOfCups = Math.min(numOfCupsFromGivenWater, numOfCupsFromGivenMilk);
        deliverableNumberOfCups = Math.min(deliverableNumberOfCups, numOfCupsFromGivenCoffeeBean);

        return deliverableNumberOfCups;
    }

    private static void calculateAmounts(int numberOfCupsNeeded, int numberOfCupsCanDeliver) {
        if (numberOfCupsNeeded == numberOfCupsCanDeliver) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numberOfCupsNeeded > numberOfCupsCanDeliver) {
            String msg = String.format("No, I can make only %s cup(s) of coffee", numberOfCupsCanDeliver);
            System.out.println(msg);
        } else {
            int excessCups = numberOfCupsCanDeliver - numberOfCupsNeeded;
            String msg = String.format("Yes, I can make that amount of coffee (and even %s more than that)", excessCups);
            System.out.println(msg);
        }
    }
}
