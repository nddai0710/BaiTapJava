package data;

public class Asset extends AssetID {
    private String name, color;
    private double price, weight;
    private int quantity;

    public Asset(String id, String name, String color, double price, double weight, int quantity) {
        super(id);
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-10s%-10.1f%-10.1f%-5d", id, name, color, price, weight, quantity);
    }
}
