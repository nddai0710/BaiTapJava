package main;

import data.Employee;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SetupData {
    public static void main(String[] args) throws Exception {
        // 1. Tạo file Employee có sẵn Manager
        ArrayList<Employee> eList = new ArrayList<>();
        // Pass 123456 mã hóa MD5: e10adc3949ba59abbe56e057f20f883e
        eList.add(new Employee("E001", "Mr.Admin", "MA", "e10adc3949ba59abbe56e057f20f883e"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        oos.writeObject(eList);
        oos.close();
        System.out.println("Done data init!");
    }
}