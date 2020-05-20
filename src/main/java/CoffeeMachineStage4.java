import java.math.BigDecimal;
import java.util.Scanner;

public class CoffeeMachineStage4 {
    private BigDecimal amountOfMoney;
    private int amountOfWater;
    private int amountOfMilk;
    private int amountOfCoffee;
    private int numberOfCups;
    Scanner scanner = new Scanner(System.in);

    public CoffeeMachineStage4() {
        this.amountOfMoney = BigDecimal.valueOf(550.00);
        this.amountOfWater = 400;
        this.amountOfMilk = 540;
        this.amountOfCoffee = 120;
        this.numberOfCups = 9;
    }

    public static void main(String[] args) {
        CoffeeMachineStage4 coffeeMachine = new CoffeeMachineStage4();
        coffeeMachine.process();
    }

    private void process() {
        printStateOfTheMachine(getAmountWater(), getAmountMilk(), getAmountCoffee(), getNumberOfCups(), getAmountMoney());

        String action = getUserAction();
        switch (action) {
            case "buy":
                operateBuyAction();
                break;
            case "fill":
                operateFillAction();
                break;
            case "take":
                operateTakeAction();
                break;
            default:
                break;
        }
        printStateOfTheMachine(getAmountWater(), getAmountMilk(), getAmountCoffee(), getNumberOfCups(), getAmountMoney());
    }

    private void printStateOfTheMachine(int water, int milk, int coffee, int cups, BigDecimal money) {
        String msgWater = String.format("%s of water", water);
        String msgMilk = String.format("%s of milk", milk);
        String msgCoffee = String.format("%s of coffee beans", coffee);
        String msgCups = String.format("%s of disposable cups", cups);
        String msgMoney = String.format("%s of money", money);

        System.out.println("\nThe coffee machine has: ");
        System.out.println(msgWater);
        System.out.println(msgMilk);
        System.out.println(msgCoffee);
        System.out.println(msgCups);
        System.out.println(msgMoney);
    }

    private String getUserAction() {
        System.out.println("Write action (buy, fill, take): ");
        return scanner.nextLine();
    }

    private void operateBuyAction() {
        int coffeeType = getCoffeeType();
        if (coffeeType == 1) {// espresso
            setAmountWater("buy", 250);
            setAmountCoffee("buy", 16);
            setAmountMoney("buy", BigDecimal.valueOf(4.00));
            setNumberOfCups("buy", 1);
        } else if (coffeeType == 2) {// latte
            setAmountWater("buy", 350);
            setAmountMilk("buy", 75);
            setAmountCoffee("buy", 20);
            setAmountMoney("buy", BigDecimal.valueOf(7.00));
            setNumberOfCups("buy", 1);
        } else if (coffeeType == 3) {// cappuccino
            setAmountWater("buy", 200);
            setAmountMilk("buy", 100);
            setAmountCoffee("buy", 12);
            setAmountMoney("buy", BigDecimal.valueOf(6.00));
            setNumberOfCups("buy", 1);
        }
    }

    private int getCoffeeType() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        return scanner.nextInt();
    }

    private void operateFillAction() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        setAmountWater("fill", water);

        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        setAmountMilk("fill", milk);

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffee = scanner.nextInt();
        setAmountCoffee("fill", coffee);

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        setNumberOfCups("fill", cups);
    }

    private void operateTakeAction() {
        BigDecimal money = getAmountMoney();
        String msgTake = String.format("I gave you $%s", money);
        System.out.println(msgTake);
        setAmountMoney("take", money);
    }

    public BigDecimal getAmountMoney() {
        return amountOfMoney;
    }

    public void setAmountMoney(String action, BigDecimal money) {
        if (action.equals("buy")) {
            this.amountOfMoney.add(money);
        } else if (action.equals("take")) {
            this.amountOfMoney.valueOf(0);
        }
    }

    public int getAmountWater() {
        return amountOfWater;
    }

    public void setAmountWater(String action, int water) {

        if (action.equals("buy")) {
            this.amountOfWater = amountOfWater - water;
        } else if (action.equals("fill")) {
            this.amountOfWater = amountOfWater + water;
        }
    }

    public int getAmountMilk() {
        return amountOfMilk;
    }

    public void setAmountMilk(String action, int milk) {

        if (action.equals("buy")) {
            this.amountOfMilk = amountOfMilk - milk;
        } else if (action.equals("fill")) {
            this.amountOfMilk = amountOfMilk + milk;
        }
    }

    public int getAmountCoffee() {
        return amountOfCoffee;
    }

    public void setAmountCoffee(String action, int coffee) {

        if (action.equals("buy")) {
            this.amountOfCoffee = amountOfCoffee - coffee;
        } else if (action.equals("fill")) {
            this.amountOfCoffee = amountOfCoffee + coffee;
        }
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(String action, int cups) {

        if (action.equals("buy")) {
            this.numberOfCups = numberOfCups - cups;
        } else if (action.equals("fill")) {
            this.numberOfCups = numberOfCups + cups;
        }
    }
}
