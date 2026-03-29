import java.util.Calendar;
import java.util.Scanner;

public class validation {
    private static Scanner sc = new Scanner(System.in);

    private static String PHONE_VALID = "^\\d{10,}$";
    private static String EMAIL_VALID = "^[A-Za-z0-9+_.-]+@(.+)$";

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

    public static boolean checkInputYN(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.println("Nhap Y hoac N.");
            System.out.print("Nhap lai: ");
        }
    }

    public static String checkInputPhone(){
        while(true){
            String result = checkInputString();
            if(result.matches(PHONE_VALID)){
                return result;
            }
            System.err.println("SDT phai la so va it nhat 10 ky tu.");
            System.out.print("SDT: ");
        }
    }

    public static String checkInputEmail(){
        while(true){
            String result = checkInputString();
            if(result.matches(EMAIL_VALID)){
                return result;
            }
            System.err.println("Email nhap sai.");
            System.out.print("Email: ");
        }
    }

    public static int checkInputBirthDate(){
        while (true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                if(result >= 1900 && result <= currentYear){
                    return result;
                }
                System.err.println("Nam sinh phai tu 1900 den " + currentYear);
                System.out.print("Ngay sinh: ");
            }catch (NumberFormatException e){
                System.err.println("Khong duoc de trong");
                System.out.print("Nhap ngay sinh: ");
            }
        }
    }

    public static int checkInputExprience(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return  result;
            }catch (NumberFormatException e){
                System.err.println("Kinh nghiem phai tu " + min + " den " + max );
                System.out.println("Kinh nghiem: ");
            }
        }
    }

    public static String checkInputGraduationRank(){
        while(true){
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence") ||
                    result.equalsIgnoreCase("Good") ||
                    result.equalsIgnoreCase("Fair") ||
                    result.equalsIgnoreCase("Poor")) {
                return result;
            }
            System.err.println("Rank chi duoc nhap : Excellence, Good, Fair, Poor");
            System.out.print("Rank: ");
        }
    }

    public static int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.err.println("Chon tu " + min + " den " + max);
                System.out.println("Chon lai: ");
            }
        }
    }

}
