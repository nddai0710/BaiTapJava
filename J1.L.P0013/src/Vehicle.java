import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
    protected String name, color, vehicleId, brand;
    protected int price;

    public Vehicle() {
    }

    public Vehicle(String name, String color, String vehicleId, String brand, int price) {
        this.name = name;
        this.color = color;
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected void createVehicle() {
        this.vehicleId = Validation.getString("Vehicle ID: ");
        this.name = Validation.getString("Name: ");
        this.brand = Validation.getString("Brand: ");
        this.color = Validation.getColor("Color (Blue/Green/Red): ");
        this.price = Validation.getGreaterThan0("Price: ");
    }

    protected void updateVehicle() {
        this.name = Validation.updateString(this.name, "Update Name: ");
        this.brand = Validation.updateString(this.brand, "Update Brand: ");
        this.color = Validation.updateColor(this.color, "Update Color (Blue/Green/Red): ");
        this.price = Validation.updateGreaterThan0(this.price, "Update Price: ");
    }

    @Override
    public String toString() {
        return String.format("| %-8s | %-15s | %-10s | %-6s | %4d$ |",
                vehicleId, name, brand, color, price);
    }

    @Override
    public boolean equals(Object obj) {
        return this.vehicleId.equalsIgnoreCase(((Vehicle) obj).getVehicleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, vehicleId, brand, price);
    }
}