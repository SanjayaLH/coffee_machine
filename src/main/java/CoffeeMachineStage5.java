import java.util.Scanner;

public class CoffeeMachineStage5 {
    private int amountMoney = 550;
    private int amountWater = 400;
    private int amountMilk = 540;
    private int amountCoffee = 120;
    private int numberOfCups = 9;

    public int getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(String action, int money) {
        if (action.equals("buy")) {
            this.amountMoney = amountMoney + money;
        } else if (action.equals("take")) {
            this.amountMoney = 0;
        }
    }

    public int getAmountWater() {
        return amountWater;
    }

    public void setAmountWater(String action, int water) {

        if (action.equals("buy")) {
            this.amountWater = amountWater - water;
        } else if (action.equals("fill")) {
            this.amountWater = amountWater + water;
        }
    }

    public int getAmountMilk() {
        return amountMilk;
    }

    public void setAmountMilk(String action, int milk) {

        if (action.equals("buy")) {
            this.amountMilk = amountMilk - milk;
        } else if (action.equals("fill")) {
            this.amountMilk = amountMilk + milk;
        }
    }

    public int getAmountCoffee() {
        return amountCoffee;
    }

    public void setAmountCoffee(String action, int coffee) {

        if (action.equals("buy")) {
            this.amountCoffee = amountCoffee - coffee;
        } else if (action.equals("fill")) {
            this.amountCoffee = amountCoffee + coffee;
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

    private void printStateOfTheMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        String msgWater = String.format("%s of water", water);
        String msgMilk = String.format("%s of milk", milk);
        String msgCoffee = String.format("%s of coffee beans", coffeeBeans);
        String msgCups = String.format("%s of disposable cups", cups);
        String msgMoney = String.format("%s of money", money);

        System.out.println("The coffee machine has: ");
        System.out.println(msgWater);
        System.out.println(msgMilk);
        System.out.println(msgCoffee);
        System.out.println(msgCups);
        System.out.println(msgMoney);
    }

    private String getUserAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String getCoffeeType() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void actionBuy() {
        String coffeeType = getCoffeeType();
        int water = getAmountWater();
        int milk = getAmountMilk();
        int coffee = getAmountCoffee();
        int cups = getNumberOfCups();

        switch (coffeeType) {
            case "1": // espresso
                if (water >= 250 && coffee >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    setAmountWater("buy", 250);
                    setAmountCoffee("buy", 16);
                    setAmountMoney("buy", 4);
                    setNumberOfCups("buy", 1);
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (coffee < 16) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups == 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "2": // latte
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    setAmountWater("buy", 350);
                    setAmountMilk("buy", 75);
                    setAmountCoffee("buy", 20);
                    setAmountMoney("buy", 7);
                    setNumberOfCups("buy", 1);
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffee < 20) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups == 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "3": // cappuccino
                if (water >= 200 && milk >= 100 && coffee >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    setAmountWater("buy", 200);
                    setAmountMilk("buy", 100);
                    setAmountCoffee("buy", 12);
                    setAmountMoney("buy", 6);
                    setNumberOfCups("buy", 1);
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffee < 12) {
                        System.out.println("Sorry, not enough coffee!");
                    } else if (cups == 0) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "back": //back to main menu
                process();
                break;
            default:
                break;
        }
    }

    private void actionFill() {
        Scanner scanner = new Scanner(System.in);
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

    private void actionTake() {
        int money = getAmountMoney();
        String msgTake = String.format("I gave you $%s", money);
        System.out.println(msgTake);
        setAmountMoney("take", money);
    }

    private void process() {
        boolean isLooped = true;
        while (isLooped) {
            String action = getUserAction();
            switch (action) {
                case "buy":
                    actionBuy();
                    isLooped = true;
                    break;
                case "fill":
                    actionFill();
                    isLooped = true;
                    break;
                case "take":
                    actionTake();
                    isLooped = true;
                    break;
                case "remaining":
                    printStateOfTheMachine(getAmountWater(), getAmountMilk(), getAmountCoffee(), getNumberOfCups(), getAmountMoney());
                    isLooped = true;
                    break;
                case "exit":
                    isLooped = false;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CoffeeMachineStage5 coffeeMachine = new CoffeeMachineStage5();
        coffeeMachine.process();
    }
}
