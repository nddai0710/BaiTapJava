public class Motorbike extends Vehicle {
    private double speed;
    private boolean license;

    public Motorbike(String id, String name, String color, String brand, double price, double speed, boolean license) {
        super(id, name, color, brand, price);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }


    public void makeSound(){
        System.out.println("Tin tin tin");
    }

    @Override
    public void showInfo() {
        System.out.printf("MOTORBIKE|", id, name, color, price, brand, speed, license);
    }
}
