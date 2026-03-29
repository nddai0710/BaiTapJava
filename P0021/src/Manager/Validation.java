package Manager;

import Entity.Report;
import Entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    private final static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) { // doc 1 so nguyen tu ban phim, xem no nam trong khoang nao
        while (true){
            try{
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result < min || result > max){
                    throw  new NumberFormatException();
                }
                return result;
            }catch (NumberFormatException e){
                System.err.println("Please enter a number between " + min + " and " + max);
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString(){ // nhap 1 chuoi tu ban phim, de dam bao no khong duoc trong
        while(true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println("Please enter a string");
                System.out.print("Enter again: ");
            }else{
                return result;
            }
        }
    }

    public static boolean checkInputYN(){ // chi chap nhan Y hoac N, cho phep viet chu thuong
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }
            if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please input Y or N");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputUD(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("U")){
                return true;
            }
            if(result.equalsIgnoreCase("D")){
                return false;
            }
            System.err.println("Please input U or D");
            System.out.print("Enter again: ");
        }
    }

    //chi chap nhan java, .net, C/C++
    public static String checkInputCourse(){
        while(true){
            String result = checkInputString();
            if(result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")){
                return result;
            }
            System.err.println("Please input a course name");
            System.out.print("Enter again: ");
        }
    }

    //kiem tra xem ban ghi sinh vien (id + name + semester + course) da ton tai trong danh sach chua
    // de tranh them trung hoan toan 1 ban ghi
    public static boolean checkStudentExists(ArrayList<Student> ls, String id, String studentName, String semester, String courseName){
        int size = ls.size();
        for(Student s : ls){
            if(id.equalsIgnoreCase(s.getId()) && studentName.equalsIgnoreCase(s.getStudentName()) && semester.equalsIgnoreCase(s.getSemester()) && courseName.equalsIgnoreCase(s.getCourseName())){
                return true; // tim thay ban ghi trung hoan toan
            }
        }
        return false; // cho phep them
    }

    //kiem tra xem ban ghi Report (name + course + total) da ton tai trong danh sach bao cao chua
    //De tranh them trung 1 muc vao danh sach bao cao
    public static boolean checkReportExists(ArrayList<Report> lr, String name, String course, int total ){
        for(Report r : lr){
            if(name.equalsIgnoreCase(r.getStudentName()) && course.equalsIgnoreCase(r.getCourseName()) && total == r.getTotalCourse()){
                return true; // neu ban ghi da ton tai trong bao cao
            }
        }
        return false; //neu ban ghi chua ton tai trong bao cao
    }


    //Kiem tra ID co dang thuoc ve 1 sinh vien khac ten khong
    public static boolean checkIDExists(ArrayList<Student> ls, String id, String name){
        for(Student s : ls){
            //ID trung nhung ten khac nen ID nay dang thuoc ve nguoi khac
            if(id.equalsIgnoreCase(s.getId()) && !name.equalsIgnoreCase(s.getStudentName())){
                return false; // id da thuoc ve nguoi khac
            }
        }
        return true; // id chua bi dung
    }

    //Kiem tra thong tin moi co khac thong tin hien tai khong
    //Tranh cap nhat nhung thuc ra nhap lai dung du lieu cu
    public static boolean checkChangeInfomation(Student student, String id,
                                                String name, String semester, String course) {
        //neu 4 truong giong cu thi khong co thay doi
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false; // khong co gi thay doi
        }
        return true; // co it nhat 1 truong khac thi cap nhat
    }
}
