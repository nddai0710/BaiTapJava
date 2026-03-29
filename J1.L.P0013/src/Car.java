public class Car extends Vehicle{
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String name, String color, String vehicleId, String brand, int price, String type, int yearOfManufacture) {
        super(name, color, vehicleId, brand, price);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.type = Validation.getType("Type (Sport/Travel/Common): ");
        this.yearOfManufacture = Validation.getYear("Year of manufacture: ");
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.type = Validation.updateType(this.type, "Update Type (Sport/Travel/Common): ");
        this.yearOfManufacture = Validation.updateYear(this.yearOfManufacture, "Update Year: ");
    }

    @Override
    public String toString() {
        return "CAR " + super.toString() + String.format(" %-10s | %4d |", type, yearOfManufacture);
    }
}
