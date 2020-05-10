import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        Scanner scanner = new Scanner(System.in);
        int numberOfCups = scanner.nextInt();
        String msg = String.format("For %s cups of coffee you will need:", numberOfCups);
        System.out.println(msg);
        calculateAmounts(numberOfCups);
    }

    private static void calculateAmounts(int numberOfCups) {
        int amountOfWater = numberOfCups * 200;
        int amountOfMilk = numberOfCups * 50;
        int amountOfCoffeeBeans = numberOfCups * 15;

        String msgWater = String.format("%s ml of water", amountOfWater);
        String msgMilk = String.format("%s ml of milk", amountOfMilk);
        String msgCoffee = String.format("%s g of coffee beans", amountOfCoffeeBeans);

        System.out.println(msgWater);
        System.out.println(msgMilk);
        System.out.println(msgCoffee);
    }
}
