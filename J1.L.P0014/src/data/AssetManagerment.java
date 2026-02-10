package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AssetManagerment implements I_FunctionList {

    // Load dữ liệu từ file
    AssetList assets = new AssetList();
    EmployeeList employees = new EmployeeList();
    RequestList requests = new RequestList();
    BorrowList borrows = new BorrowList();

    // Biến lưu ID người đang đăng nhập
    private String currentUser = null;

    // --- 1. LOGIN ---
    @Override
    public int login() {
        System.out.println("----- LOGIN -----");
        String id = Validation.getString("User ID: ");
        String pass = Validation.getString("Password: ");

        Employee emp = employees.checkLogin(id, pass);
        if (emp != null) {
            this.currentUser = emp.getId(); // Lưu ID người dùng
            System.out.println("Welcome " + emp.getName());
            return emp.getRole().equalsIgnoreCase("MA") ? 1 : 2;
        }
        System.out.println("Login Failed! Incorrect ID or Password.");
        return 0;
    }

    // --- 2. SEARCH ---
    @Override
    public void searchAsset() {
        String name = Validation.getString("Search Name: ").toLowerCase();
        ArrayList<Asset> result = new ArrayList<>();
        for (Asset a : assets) {
            if (a.getName().toLowerCase().contains(name)) result.add(a);
        }

        if (result.isEmpty()) System.out.println("No asset found.");
        else {
            Collections.sort(result, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
            for (Asset a : result) System.out.println(a);
        }
    }

    // --- 3. CREATE (Manager) ---
    @Override
    public void createAsset() {
        String id;
        while (true) {
            id = Validation.getString("New Asset ID: ");
            if (assets.findByID(id) == null) break;
            System.out.println("ID Existed!");
        }
        String name = Validation.getString("Name: ");
        String color = Validation.getString("Color: ");
        double price = Validation.getDouble("Price: ");
        double weight = Validation.getDouble("Weight: ");
        int qty = Validation.getInt("Quantity: ");

        assets.add(new Asset(id, name, color, price, weight, qty));
        assets.save();
        System.out.println("Asset Created!");
    }

    // --- 4. UPDATE (Manager) ---
    @Override
    public void updateAsset() {
        String id = Validation.getString("Enter Asset ID to update: ");
        Asset a = assets.findByID(id);
        if (a == null) {
            System.out.println("Asset not found!");
            return;
        }
        System.out.println("Updating " + a.getName());
        a.setName(Validation.updateString(a.getName(), "Name"));
        a.setColor(Validation.updateString(a.getColor(), "Color"));
        a.setPrice(Validation.updateDouble(a.getPrice(), "Price"));
        a.setWeight(Validation.updateDouble(a.getWeight(), "Weight"));
        a.setQuantity(Validation.updateInt(a.getQuantity(), "Quantity"));
        assets.save();
        System.out.println("Update Success!");
    }

    // --- 5. APPROVE REQUEST (Manager) ---
    @Override
    public void approveRequest() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        // Hiện danh sách
        for (Request r : requests) System.out.println(r);

        String rID = Validation.getString("Enter Request ID to Approve: ");
        Request req = null;
        // Tìm thủ công bằng vòng lặp thay vì gọi hàm lạ
        for (Request r : requests) {
            if (r.getrID().equalsIgnoreCase(rID)) {
                req = r;
                break;
            }
        }

        if (req == null) {
            System.out.println("Request ID not found.");
            return;
        }

        // Check kho
        Asset asset = assets.findByID(req.getId()); // req.getId() trả về AssetID
        if (asset != null && asset.getQuantity() >= req.getQuantity()) {
            // 1. Trừ kho
            asset.setQuantity(asset.getQuantity() - req.getQuantity());
            assets.save();

            // 2. Tạo Borrow (Chuyển từ Request sang Borrow)
            String bID = "B" + System.currentTimeMillis() % 10000;
            // Lưu ý: Request.java ông gửi có getEmployeeID, Borrow.java cũng cần constructor tương ứng
            Borrow b = new Borrow(bID, req.getId(), req.getEmployeeID(), req.getQuantity(), Validation.getCurrentDate());
            borrows.add(b);
            borrows.save();

            // 3. Xóa Request
            requests.remove(req);
            requests.save();
            System.out.println("Approve Success!");
        } else {
            System.out.println("Approve Failed! Not enough stock.");
        }
    }

    // --- 6. SHOW BORROW (Manager) ---
    @Override
    public void showBorrow() {
        if (borrows.isEmpty()) System.out.println("Borrow list empty.");
        else for (Borrow b : borrows) System.out.println(b);
    }

}