import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Manager manager = new Manager();

        // Loop menu
        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Please choose: ");

            int choice = Validation.checkInputInt(1, 5);

            switch (choice) {
                case 1:
                    manager.createStudent(ls);
                    break;
                case 2:
                    manager.findAndSort(ls);
                    break;
                case 3:
                    manager.updateOrDelete(ls);
                    break;
                case 4:
                    manager.report(ls);
                    break;
                case 5:
                    return;
            }
        }
    }
}