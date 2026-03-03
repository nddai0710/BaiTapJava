import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static String checkInputString(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Khong duoc de trong");
                System.out.print("Nhap lai: ");
            }else{
                return result;
            }
        }
    }

    public static int checkInputInt(int min, int max){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.err.println("Nhap so trong khoang " + min + " den " + max + ": ");
                System.out.println("Nhap lai: ");
            }
        }
    }

    public static String checkInputCourse(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")){
                return result;
            }
            System.err.println("Chi co 3 mon: Java, .Net, C/C++");
            System.out.println("Nhap lai ten mon: ");
        }
    }

    public static boolean checkInputYN(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")) return true;
            if(result.equalsIgnoreCase("N")) return false;
            System.out.print("Nhap Y hoac N: ");
        }
    }

    public static boolean checkInputUD(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("U")) return true;
            if(result.equalsIgnoreCase("D")) return false;
            System.out.print("Nhap U hoac N: ");
        }
    }
}
