package data;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg){
        System.out.print(msg);
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Khong trong");
                System.out.print("Nhap lai: ");
            }else{
                return result;
            }
        }
    }

    public static int getInt(String msg){
        System.out.print(msg);
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.err.println("Vui long nhap so");
                System.out.print("Nhap lai so: ");
            }
        }
    }

    public static double getDouble(String msg){
        System.out.print(msg);
        while(true){
            try{
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            }catch (NumberFormatException e){
                System.err.println("Vui long nhap so");
                System.out.print("Nhap lai so: ");
            }
        }
    }

    public static String updateString(String oldValue, String msg){
        System.out.print(msg + " (Old: " + oldValue + "): ");
        String s = sc.nextLine().trim();
        return s.isEmpty() ? oldValue : s;
    }

    public static double updateDouble(Double oldValue, String msg){
        System.out.print(msg + " (Old: " + oldValue + "): ");
        String s = sc.nextLine().trim();
        if(s.isEmpty()) return oldValue;
        try{
            return Double.parseDouble(s);
        }catch(Exception e){
            return oldValue;
        }
    }

    public static int updateInt(int oldValue, String msg){
        System.out.print(msg + " (Old: " + oldValue + "): ");
        String s = sc.nextLine().trim();
        if(s.isEmpty()) return oldValue;
        try{
            return Integer.parseInt(s);
        }catch (Exception e){
            return oldValue;
        }
    }

    public static String getMd5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        }catch (Exception e){
            return "";
        }
    }

    public static String getCurrentDate(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }
}
