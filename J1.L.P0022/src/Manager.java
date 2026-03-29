import java.util.ArrayList;

public class Manager {
    ArrayList<Candidate> candidates = new ArrayList<>();

    public void menu(){
        System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.println("Choose: ");
    }

    public void createCandidate(int type){
        while(true){
            System.out.print("Nhap ID: ");
            String id = validation.checkInputString();
            System.out.print("Nhap Ho: ");
            String firstName = validation.checkInputString();
            System.out.print("Nhap Ten: ");
            String lastName = validation.checkInputString();
            System.out.print("Nhap Nam sinh: ");
            int birthDate = validation.checkInputBirthDate();
            System.out.print("Nhap dia chi: ");
            String address = validation.checkInputString();
            System.out.print("Nhap so dien thoai: ");
            String phone = validation.checkInputPhone();
            System.out.print("Nhap email: ");
            String email = validation.checkInputEmail();

            switch (type){
                case 0:
                    System.out.print("Nhap so nam kinh nghiem: ");
                    int yearExperience = validation.checkInputExprience(0, 100);
                    System.out.print("Nhap ki nang chuyen mon: ");
                    String proSkill = validation.checkInputString();
                    candidates.add(new Experience(id, firstName, lastName, birthDate, address, phone, email, 0, yearExperience, proSkill));
                    break;
                case 1:
                    System.out.print("Nhap nam tot nghiep: ");
                    String graduationDate = validation.checkInputString();
                    System.out.print("Nhap loai tot nghiep (Excellence, Good, Fair, Poor): ");
                    String graduationRank = validation.checkInputGraduationRank();
                    System.out.print("Nhap truong: ");
                    String education = validation.checkInputString();
                    candidates.add(new Fresher(id, firstName, lastName, birthDate, address, phone, email, 1, graduationDate, graduationRank, education));
                    break;
                case 2:
                    System.out.print("Nhap chuyen nganh: ");
                    String major = validation.checkInputString();
                    System.out.print("Nhap hoc ky: ");
                    String semester = validation.checkInputString();
                    System.out.print("Nhap truong dai hoc: ");
                    String university = validation.checkInputString();
                    candidates.add(new Intern(id, firstName, lastName, birthDate, address, phone, email, 2, major, semester, university));
                    break;
            }
            System.out.println("Them thanh cong");
            System.out.print("Ban co muon tiep tuc(Y/N)? ");
            if(!validation.checkInputYN()){
                printListNameCandidate();
                return;
            }
        }
    }

    public void printListNameCandidate(){
        System.out.println("=========EXPERIENCE CANDIDATE=============");
        for(Candidate c :  candidates){
            if(c instanceof Experience){
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }

        System.out.println("============FRESHER CANDIDATE==============");
        for(Candidate c :  candidates){
            if(c instanceof Fresher){
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }

        System.out.println("============INTERN CANDIDATE==============");
        for (Candidate c :  candidates){
            if(c instanceof Intern){
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }
        }
    }

    public void searchCandidate(){
        printListNameCandidate();
        System.out.print("Nhap ten ung vien: ");
        String nameSearch = validation.checkInputString().toLowerCase();
        System.out.print("Nhap loai ung vien: ");
        int typeSearch = validation.checkInputIntLimit(0,2);
        System.out.println("Cac ung vien da tim thay");
        boolean found = false;
        for (Candidate c : candidates) {
            if (c.getType() == typeSearch &&
                    (c.getFirstName().toLowerCase().contains(nameSearch) ||
                            c.getLastName().toLowerCase().contains(nameSearch))) {

                System.out.println(c.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Khong tim thay");
    }
}
