public class Motorbike extends Vehicle{
    private String license;
    private int speed;
    private static String MAKE_SOUND = "Tin tin tin";

    public Motorbike() {}

    public Motorbike(String name, String color, String vehicleId, String brand, int price, String license, int speed) {
        super(name, color, vehicleId, brand, price);
        this.license = license;
        this.speed = speed;
    }

    public Motorbike(String name, String color, String vehicleId, String brand, int price) {
        super(name, color, vehicleId, brand, price);
    }

    @Override
    protected void createVehicle() {
        super.createVehicle();
        this.license = Validation.getYesNo("Required license (Yes/No): ");
        this.speed = Validation.getGreaterThan0("Speed: ");
    }

    @Override
    protected void updateVehicle() {
        super.updateVehicle();
        this.license = Validation.updateYesNo(this.license, "Update License (Yes/No): ");
        this.speed = Validation.updateGreaterThan0(this.speed, "Update Speed: ");
    }

    @Override
    public String toString() {
        return "MOTO" + super.toString() + String.format(" %-10s | %4d km/h | %s", license, speed, MAKE_SOUND);
    }
}
