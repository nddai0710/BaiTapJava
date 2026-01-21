import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static String checkInputString(String msg){
        while(true){
            System.out.print(msg);
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("khong duoc phep trong");
            }else{
                return result;
            }
        }
    }

    public static int checkInputInt(String msg){
        while(true){
            try{
                System.out.println(msg);
                return Integer.parseInt(sc.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Nhap so nguyen: ");
            }
        }
    }

    public static double checkInputDouble(String msg){
        while (true){
            try{
                System.out.println(msg);
                return Double.parseDouble(sc.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Nhap so thuc: ");
            }
        }
    }

    public static boolean checkInputBoolean(String msg){
        while(true){
            System.out.println(msg + " (Y/N): ");
            String result = sc.nextLine().trim();
            if(result.equalsIgnoreCase("Y")) return true;
            if(result.equalsIgnoreCase("N")) return false;
            System.out.println("Nhap Y hoac N");
        }
    }

    public static String updateString(String msg, String oldValue){
        System.out.println(msg + " (Old: " + oldValue + ")");
        String result = sc.nextLine().trim();
        if(result.isEmpty()){
            return oldValue;
        }
        return result;
    }

    public static int updateInt(String msg, int oldValue){
        System.out.println(msg + " (Old: " + oldValue + ")");
        String result = sc.nextLine().trim();
        if(result.isEmpty()){
            return oldValue;
        }
        try{
            return Integer.parseInt(result);
        }catch (NumberFormatException e){
            System.out.println("Sai dinh dang");
            return oldValue;
        }
    }

    public static double updateDouble(String msg, double oldValue){
        System.out.println(msg + " (Old: " + oldValue + ")");
        String result = sc.nextLine().trim();
        if(result.isEmpty()){
            return oldValue;
        }
        try{
            return Double.parseDouble(result);
        }catch (NumberFormatException e){
            System.out.println("Sai dinh dang");
            return oldValue;
        }
    }
}
