public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        while (true) {
            System.out.println("\nFRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.checkInputIntLimit(1, 4);

            switch (choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    manager.viewOrder();
                    break;
                case 3:
                    manager.shopping();
                    break;
                case 4:
                    System.out.println("Bye bye!");
                    return;
            }
        }
    }
}