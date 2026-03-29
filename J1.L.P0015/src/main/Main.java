package main;
import data.AssetManagerment;
import data.Validation;

public class Main {
    public static void main(String[] args) {
        AssetManagerment app = new AssetManagerment();

        // Vòng lặp đăng nhập
        while (true) {
            int role = app.login();
            if (role == 1) { // Manager
                menuManager(app);
            } else if (role == 2) { // Employee
                menuEmployee(app);
            } else {
                if (Validation.getString("Do you want to exit (Y/N)? ").equalsIgnoreCase("Y")) break;
            }
        }
    }

    public static void menuManager(AssetManagerment app) {
        while (true) {
            System.out.println("\n--- MANAGER MENU ---");
            System.out.println("1. Search Asset");
            System.out.println("2. Create Asset");
            System.out.println("3. Update Asset");
            System.out.println("4. Approve Request");
            System.out.println("5. Show Borrow List");
            System.out.println("6. Logout");

            int c = Validation.getInt("Choose: ");
            switch (c) {
                case 1: app.searchAsset(); break;
                case 2: app.createAsset(); break;
                case 3: app.updateAsset(); break;
                case 4: app.approveRequest(); break;
                case 5: app.showBorrow(); break;
                case 6: return;
            }
        }
    }

    public static void menuEmployee(AssetManagerment app) {
        while (true) {
            System.out.println("\n--- EMPLOYEE MENU ---");
            System.out.println("1. Search Asset");
            System.out.println("2. Borrow Asset");  // Lab 3
            System.out.println("3. Cancel Request"); // Lab 3
            System.out.println("4. Return Asset");   // Lab 3
            System.out.println("5. Logout");

            int c = Validation.getInt("Choose: ");
            switch (c) {
                case 1: app.searchAsset(); break;
                case 2: app.borrowAsset(); break;
                case 3: app.cancelRequest(); break;
                case 4: app.returnAsset(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}