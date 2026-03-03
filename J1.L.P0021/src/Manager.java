import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    public void createStudent(ArrayList<Student> ls){

        while (true){
            System.out.println("---- Them Sinh Vien ----");
            System.out.print("Nhap ID: ");
            String id = Validation.checkInputString();
            System.out.print("Nhap Ten: ");
            String name = Validation.checkInputString();

            System.out.print("Nhap Hoc ky: ");
            String semester = Validation.checkInputString();
            System.out.print("Nhap khoa hoc (Java, .Net, C/C++): ");
            String course = Validation.checkInputCourse();

            ls.add(new Student(id, name, semester, course));
            System.out.println("Them thanh cong");

            if (ls.size() >= 3) {
                System.out.print("Ban co muon tiep tuc(Y/N)? ");
                if (!Validation.checkInputYN()) {
                    return;
                }
            } else {
                System.out.println("Cần nhập đủ 10 sinh viên (Hiện tại: " + ls.size() + ")");
            }
        }
    }

        public void findAndSort(ArrayList<Student> ls){
            if(ls.isEmpty()){
                System.err.println("Danh sach trong");
                return;
            }
            System.out.print("Nhap ten can tim: ");
            String name = Validation.checkInputString();

            ArrayList<Student> listFound = new ArrayList<>();
            for(Student student : ls){
                if(student.getStudentName().toLowerCase().contains(name.toLowerCase())){
                    listFound.add(student);
                }
            }

            if(listFound.isEmpty()){
                System.err.println("Khong tim thay");
            }else{
                Collections.sort(listFound);
                System.out.printf("%-15s | %-15s | %-10s\n", "Name", "Semester", "Course");
                for (Student student : listFound) {
                    student.print();
                }
            }
        }

        public void updateOrDelete(ArrayList<Student> ls){
            if(ls.isEmpty()){
                System.err.println("Danh sach trong");
                return;
            }
            System.out.print("Nhap ID: ");
            String id = Validation.checkInputString();

            ArrayList<Student> listFoundByID = new ArrayList<>();
            for(Student student : ls){
                if(student.getId().equalsIgnoreCase(id)){
                    listFoundByID.add(student);
                }
            }

            if(listFoundByID.isEmpty()){
                System.err.println("Khong tim thay id " + id);
                return;
            }else{
                System.out.print("Ban muon sua(U) hay xoa(D): ");
                if(Validation.checkInputUD()){
                    System.out.print("Nhap ten moi: ");
                    String name = Validation.checkInputString();
                    System.out.print("Nhap hoc ky moi: ");
                    String semester = Validation.checkInputString();
                    System.out.print("Nhap ten khoa hoc moi: ");
                    String course = Validation.checkInputCourse();

                    Student s = listFoundByID.get(0);
                    s.setStudentName(name);
                    s.setSemester(semester);
                    s.setCourseName(course);
                    System.out.println("Sua thanh cong");
                }else{
                    ls.remove(listFoundByID.get(0));
                    System.out.println("Xoa thanh cong!");
                }
            }
        }

        public void report(ArrayList<Student> ls) {
            if (ls.isEmpty()) {
                System.out.println("Danh sach trong");
                return;
            }

            ArrayList<String> checked = new ArrayList<>();

            System.out.printf("%-15s | %-10s | %-5s\n", "Name", "Course", "Total");

            for (Student s1 : ls) {
                String key = s1.getId() + "#" + s1.getCourseName();

                if (!checked.contains(key)) {
                    int total = 0;
                    // Đếm số lần xuất hiện của ID đó học môn đó
                    for (Student s2 : ls) {
                        if (s1.getId().equalsIgnoreCase(s2.getId())
                                && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
                            total++;
                        }
                    }
                    System.out.printf("%-15s | %-10s | %-5d\n", s1.getStudentName(), s1.getCourseName(), total);
                    checked.add(key);
                }
            }
        }
    }
