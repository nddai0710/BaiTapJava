package Manager;

import Entity.Student;
import Entity.Report;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    public static void menu(){
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void createStudent(int count, ArrayList<Student> ls){
        if(count > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if(!Validation.checkInputYN()){
                return;
            }
        }
        while(true){
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter name stundet: ");
            String name = Validation.checkInputString();
            if(Validation.checkIDExists(ls,id,name)){
                System.err.println("Id has exist student");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = Validation.checkInputString();
            System.out.print("Enter course: ");
            String course = Validation.checkInputString();

            if(!Validation.checkStudentExists(ls,id,name,semester,course)){
                ls.add(new Student(id,name,semester,course));
                count++;
                System.out.println("Student created");
                return;
            }
            System.err.println("Duplicate");
        }
    }

    //tim sinh vien theo ten roi sap xep ket qua theo hoc ky
    public static void findAndSort(ArrayList<Student> ls){
        if(ls.isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        System.out.print("Enter name to search: ");
        String name = Validation.checkInputString();
        ArrayList<Student> result = new ArrayList<>();
        for(Student s : ls){
            if (s.getStudentName().toLowerCase().contains(name.toLowerCase())){
                result.add(s);
            }
        }
        if(result.isEmpty()){
            System.err.println("No student found with name " + name);
        }else{
            Collections.sort(result);
            System.out.printf("%-15s | %-15s | %-10s\n", "Name", "Semester", "Course");
            System.out.println("-");
            for(Student s : result){
                s.print();
            }
        }
    }

    public static void updateOrDelete(ArrayList<Student> ls){
        if(ls.isEmpty()){
            //thoat khi danh sach trong
            System.out.println("The list is empty");
            return;
        }

        System.out.print("Enter student ID: ");
        String id = Validation.checkInputString();

        //tim sinh vien co ID Khop
        //khoi tao null, neu sau vong lap van null thi la khong tim thay
        Student found = null;
        for(Student s : ls){
            if(s.getId().equalsIgnoreCase(id)){
                found = s; // luu tham chieu den object tim duoojc
                break; // dung lai ngay sau khi tim thay
            }
        }

        if(found == null){
            //khong tim duoc bao loi roi thoat
            System.err.println("No student found with id " + id);
            return;
        }

        System.out.print("Update(U) or Delete(D): ");
        if(Validation.checkInputUD()){
            System.out.print("Enter new name: ");
            found.setStudentName(Validation.checkInputString());
            System.out.print("ENter new semester: ");
            found.setSemester(Validation.checkInputString());
            System.out.print("Enter new course: ");
            found.setCourseName(Validation.checkInputString());

            System.out.println("update successful");
        }else{
            ls.remove(found);
            System.out.println("delete successful");
        }
    }

    public static void report(ArrayList<Student> ls){
        if(ls.isEmpty()){
            System.out.println("The list is empty");
            return;
        }

        ArrayList<Report> checked = new ArrayList<>();

            for(Student student : ls){
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();

                int total = 0;
                for(Student studentCountTotal : ls){
                    if(id.equalsIgnoreCase(studentCountTotal.getId()) && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())){
                        total++;
                    }
                }
                if(!Validation.checkReportExists(checked, studentName, courseName, total)){
                    checked.add(new Report(studentName,courseName,total));
                }
            }

        for(int i = 0; i < checked.size(); i++){
            System.out.printf("%-15s|%-10s|%-5d\n", checked.get(i).getStudentName(),
                    checked.get(i).getCourseName(), checked.get(i).getTotalCourse());
        }
    }
}


