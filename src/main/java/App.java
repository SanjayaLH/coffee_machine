public class App {
    public String getGreeting() {
        return "Project coffee machine";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
