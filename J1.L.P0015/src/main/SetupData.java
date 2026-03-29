package main;

import data.Asset;
import data.Borrow;
import data.Employee;
import data.Request;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SetupData {
    public static void main(String[] args) {
        try {
            // 1. Tạo Tài khoản Manager (Pass: 123456)
            // Lưu ý: Password trong code Employee check MD5, nên ở đây phải lưu chuỗi đã mã hóa
            // "e10adc3949ba59abbe56e057f20f883e" là MD5 của "123456"
            ArrayList<Employee> eList = new ArrayList<>();
            eList.add(new Employee("E001", "Boss Manager",  "MA",  "e10adc3949ba59abbe56e057f20f883e"));
            eList.add(new Employee("E002", "Nhan Vien Quen", "EM",  "e10adc3949ba59abbe56e057f20f883e"));
            saveFile("employee.dat", eList);
            System.out.println("-> Tạo xong employee.dat");

            // 2. Tạo Tài sản mẫu (Asset)
            ArrayList<Asset> aList = new ArrayList<>();
            // ID: A001, Name: Projector, Color: White, Price: 500, Weight: 5, Qty: 10
            aList.add(new Asset("A001", "Projector Sony", "White", 500, 5, 10));
            // ID: A002, Name: Laptop Dell, Color: Black, Price: 1000, Weight: 2, Qty: 5
            aList.add(new Asset("A002", "Laptop Dell", "Black", 1000, 2, 5));
            saveFile("asset.dat", aList);
            System.out.println("-> Tạo xong asset.dat");

            // 3. Tạo Yêu cầu mượn mẫu (Request) để Manager duyệt
            // Nhân viên E002 mượn 2 cái Projector (A001)
            ArrayList<Request> rList = new ArrayList<>();
            rList.add(new Request("R001", "A001", "E002", 2, "10/02/2026"));
            saveFile("request.dat", rList);
            System.out.println("-> Tạo xong request.dat");

            // 4. Tạo file Borrow rỗng (để tránh lỗi null khi đọc)
            saveFile("borrow.dat", new ArrayList<Borrow>());
            System.out.println("-> Tạo xong borrow.dat");

            System.out.println("\n✅ SETUP THÀNH CÔNG! Giờ hãy chạy Main.java");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm hỗ trợ ghi file nhanh
    public static void saveFile(String filename, ArrayList list) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(list);
        oos.close();
    }
}