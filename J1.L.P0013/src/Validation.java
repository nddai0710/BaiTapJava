import java.time.ZonedDateTime;
import java.util.Scanner;

public class Validation {
    public static String getString(String str) {
        String result = "";
        boolean check = true;
        do{
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine().trim();
            if(!tmp.isEmpty()){
                result = tmp;
                check = false;
            }
        }while (check);
        return result;
    }

    public static int getInt(String str) {
        while (true){
            try{
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                return Integer.parseInt(sc.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("Nhap so nguyen");
            }
        }
    }

    public static String getYesNo(String str) {
        String result = "";
        boolean check = true;
        do{
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine().trim();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Yes") || tmp.equalsIgnoreCase("No"))) {
                result = tmp;
                check = false;
            }else {
                System.out.println("Nhap Yes/No");
            }
        }while (check);
        return result;
    }

    public static String updateString(String oldValue, String str){
        System.out.println(str);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine().trim();
        return tmp.isEmpty() ? oldValue : tmp;
    }

    public static int updateGreaterThan0(int oldValue, String str){
        int result = oldValue;
        boolean check = true;
        do{
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine().trim();
            if(tmp.isEmpty()){
                result = oldValue;
            }
            try{
                int number = Integer.parseInt(tmp);
                if(number > 0){
                    result = number;
                    check = false;
                }else {
                    System.out.println("Nhap so lon hon 0");
                }
            }catch(NumberFormatException e){
                System.out.println("Vui long nhap so!");
            }
        }while (check);
        return result;
    }

    public static int getGreaterThan0(String str){
        while(true){
            try{
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                int number = Integer.parseInt(sc.nextLine().trim());
                if(number > 0) return number;
                System.out.println("Nhap so lon hon 0");
            }catch(NumberFormatException e){
                System.out.println("Vui long nhap so!");
            }
        }
    }

    public static int getYear(String str){
        int yearCurrent = ZonedDateTime.now().getYear();
        while(true){
            try{
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                int number = Integer.parseInt(sc.nextLine().trim());
                if(number <= yearCurrent) return number;
                System.out.println("Khong nhap nam lon hon nam hien tai");
            }catch(NumberFormatException e){
                System.out.println("Vui long nhap so!");
            }
        }
    }

    public static int updateYear(int oldValue, String str){
        int yearCurrent = ZonedDateTime.now().getYear();
        while (true){
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine().trim();
            if(tmp.isEmpty()) return oldValue;
            try{
                int number = Integer.parseInt(tmp);
                if(number <= yearCurrent) return number;
                System.out.println("Nam khong duoc lon hon nam hien tai");
            }catch (NumberFormatException e){
                System.out.println("Vui long nhap so!");
            }
        }
    }

    public static String getColor(String str){
        while (true){
            String tmp = getString(str);
            if(tmp.equalsIgnoreCase("Blue") || tmp.equalsIgnoreCase("Green") || tmp.equalsIgnoreCase("Red")){
                return tmp;
            }
            System.out.println("Sai mau!(Blue/Green/Red)");
        }
    }

    public static String updateColor(String oldValue, String str){
        System.out.print(str);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine().trim();
        if(tmp.isEmpty()) return oldValue;
        if(tmp.equalsIgnoreCase("Blue") || tmp.equalsIgnoreCase("Green") || tmp.equalsIgnoreCase("Red")){
            return tmp;
        }
        System.out.println("Sai mau!(Blue/Green/Red)");
        return oldValue;
    }

    public static String getType(String str) {
        while (true) {
            String tmp = getString(str);
            if (tmp.equalsIgnoreCase("Sport") || tmp.equalsIgnoreCase("Travel") || tmp.equalsIgnoreCase("Common")) {
                return tmp;
            }
            System.out.println("Wrong type! (Sport/Travel/Common)");
        }
    }

    public static String updateType(String oldValue, String str) {
        System.out.print(str);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine().trim();
        if (tmp.isEmpty()) return oldValue;
        if (tmp.equalsIgnoreCase("Sport") || tmp.equalsIgnoreCase("Travel") || tmp.equalsIgnoreCase("Common")) {
            return tmp;
        }
        return oldValue;
    }

    // Helper: Update Yes/No (cho Motorbike license)
    public static String updateYesNo(String oldValue, String str) {
        System.out.print(str);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine().trim();
        if (tmp.isEmpty()) return oldValue;
        if (tmp.equalsIgnoreCase("Yes") || tmp.equalsIgnoreCase("No")) return tmp;
        System.out.println("Wrong input! Keep old value.");
        return oldValue;
    }

    public static void printMenu() {
        System.out.println("------- TABLE MENU -------");
        System.out.println("1. Load Data From File");
        System.out.println("2. Add New Vehicle");
        System.out.println("3. Update Vehicle");
        System.out.println("4. Delete Vehicle");
        System.out.println("5. Search Vehicle");
        System.out.println("6. Show Vehicle lists");
        System.out.println("7. Store Data To File");
        System.out.println("Other. Exit");
        System.out.println("--------------------------");
    }
}
