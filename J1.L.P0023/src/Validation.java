import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static String checkInputString(String s){
        while(true){
            System.out.print(s);
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Khong duoc de trong");
            }else{
                return result;
            }
        }
    }

    public static int checkInputInt(String s){
        while(true){
            try {
                System.out.print(s);
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.err.println("Phai nhap so nguyen");
            }
        }
    }

    public static double checkInputDouble(String s){
        while(true){
            try {
                System.out.print(s);
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.err.println("Phai nhap so thuc!");
            }
        }
    }

    public static boolean checkInputBoolean(String s){
        while(true){
//            System.out.print(s);
            String result = checkInputString(s);
            if(result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.println("Chi nhap Y hoac N");
        }
    }

    public static int checkInputIntLimit(int min, int max){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.err.println("Nhap so trong khoang " + min + " den " + max);
                System.out.print("Nhap lai: ");
            }
        }
    }
}
