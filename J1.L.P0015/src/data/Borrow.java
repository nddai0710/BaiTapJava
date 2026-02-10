package data;

public class Borrow extends AssetID {
    private String bID, employeeID, borrowDate;
    private int quantity;

    public Borrow(String bID, String assetID, String employeeID, int quantity, String borrowDate) {
        super(assetID);
        this.bID = bID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10s%-5d%s", bID, id, employeeID, quantity, borrowDate);
    }
}