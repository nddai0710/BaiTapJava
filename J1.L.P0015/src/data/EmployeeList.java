package data;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EmployeeList extends ArrayList<Employee> {
    private static final String FILE = "employee.dat";
    public EmployeeList() {load();}
    public void load() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))){
            this.addAll((ArrayList<Employee>) ois.readObject());
        }catch(Exception e){}
    }

    public Employee checkLogin(String id, String pass) {

        System.out.println("DEBUG: Dang co " + this.size() + " nhan vien trong List.");
        for(Employee e : this) {
            System.out.println("DEBUG: Check ID " + e.getId() + " - PassFile: " + e.getPassword());
        }

        String passMD5 = Validation.getMd5(pass);
        for (Employee e : this) {
            if (e.getId().equalsIgnoreCase(id) && e.getPassword().equals(passMD5)) {
                return e;
            }
        }
        return null;
    }
}
