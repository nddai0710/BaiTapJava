package data;

public class Request extends AssetID {
    private String rID, employeeID, requestDate;
    private int quantity;

    public Request(String rID, String assetID, String employeeID, int quantity, String requestDate) {
        super(assetID); // ID của cha là AssetID
        this.rID = rID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDate = requestDate;
    }

    public String getrID() { return rID; }
    public String getEmployeeID() { return employeeID; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return rID + " | Asset:" + id + " | Emp:" + employeeID + " | Qty:" + quantity + " | " + requestDate;
    }
}