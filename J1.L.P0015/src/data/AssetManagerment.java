package data;

import java.util.ArrayList;
import java.util.Collections;

public class AssetManagerment {
    AssetList assets = new AssetList();
    EmployeeList employees = new EmployeeList();
    RequestList requests = new RequestList();
    BorrowList borrows = new BorrowList();

    // 1. LOGIN
    public int login() {
        System.out.println("----- LOGIN -----");
        String id = Validation.getString("User ID: ");
        String pass = Validation.getString("Password: ");

        Employee emp = employees.checkLogin(id, pass);
        if (emp != null) {
            System.out.println("Welcome " + emp.getName());
            return emp.getRole().equalsIgnoreCase("MA") ? 1 : 2; // 1: Manager, 2: Employee
        }
        System.out.println("Login Failed!");
        return 0;
    }

    // 2. SEARCH
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

    // 3. CREATE
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

    // 4. UPDATE
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

    // 5. APPROVE (Chức năng khó nhất)
    public void approveRequest() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        for (Request r : requests) System.out.println(r);

        String rID = Validation.getString("Enter Request ID to Approve: ");
        Request req = null;
        for (Request r : requests) if (r.getrID().equalsIgnoreCase(rID)) req = r;

        if (req == null) {
            System.out.println("Request ID not found.");
            return;
        }

        Asset asset = assets.findByID(req.getId()); // req.getId() trả về AssetID
        if (asset != null && asset.getQuantity() >= req.getQuantity()) {
            // Transaction: Trừ kho -> Tạo Borrow -> Xóa Request
            asset.setQuantity(asset.getQuantity() - req.getQuantity());
            assets.save();

            String bID = "B" + System.currentTimeMillis() % 10000;
            borrows.add(new Borrow(bID, req.getId(), req.getEmployeeID(), req.getQuantity(), Validation.getCurrentDate()));
            borrows.save();

            requests.remove(req);
            requests.save();
            System.out.println("Approve Success!");
        } else {
            System.out.println("Approve Failed! Not enough stock.");
        }
    }

    // 6. SHOW BORROW
    public void showBorrow() {
        if (borrows.isEmpty()) System.out.println("Borrow list empty.");
        else for (Borrow b : borrows) System.out.println(b);
    }
}