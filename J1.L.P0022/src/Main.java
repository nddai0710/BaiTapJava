public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true) {
            manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    manager.createCandidate(0); // Create Experience
                    break;
                case 2:
                    manager.createCandidate(1); // Create Fresher
                    break;
                case 3:
                    manager.createCandidate(2); // Create Intern
                    break;
                case 4:
                    manager.searchCandidate();
                    break;
                case 5:
                    return;
            }
        }
    }
}