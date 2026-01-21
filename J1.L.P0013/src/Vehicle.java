public abstract class Vehicle implements Comparable<Vehicle> {
    protected String id, name, color, brand;
    protected double price;

    public Vehicle(String id, String name, String color, String brand, double price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void showInfo();

    @Override
    public int compareTo(Vehicle o) {
        return this.id.compareToIgnoreCase(o.id);
    }
}
