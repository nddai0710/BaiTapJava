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

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10s%-5d%s", bID, id, employeeID, quantity, borrowDate);
    }
}