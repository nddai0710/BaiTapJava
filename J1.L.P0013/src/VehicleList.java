import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class VehicleList extends ArrayList<Vehicle> implements I_FunctionList{
    @Override
    public void add() {
        int choice;
        do{
            System.out.println("\n-----ADD VEHICLE-----");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorbike");
            System.out.println("Other. Back");
            choice = Validation.getInt("Choose: ");
            Vehicle v = null;
            if(choice == 1) v = new Car();
            else if(choice == 2) v = new Motorbike();

            if(v != null){
                v.createVehicle();
                if(this.contains(v)){
                    System.out.println("Duplicated ID");
                }else{
                    this.add(v);
                    System.out.println("Added success");
                }
            }
        }while (choice >= 1 && choice <= 2);
    }

    @Override
    public void delete() {
        String id = Validation.getString("Enter ID to delete: ");
        int index = find(id);
        if(index != -1){
            if(Validation.getYesNo("Are you sure (Yes/No)? ").equalsIgnoreCase("Yes")){
                this.remove(index);
                System.out.println("Deleted!");
            }else {
                System.out.println("Deletion Failed");
            }
        }else {
            System.out.println("ID not found");
        }
    }

    @Override
    public void update() {
        String id = Validation.getString("Enter ID to update: ");
        int index = find(id);
        if(index != -1){
            System.out.println("Updating vehicle...");
            this.get(index).updateVehicle();
            System.out.println("Updated!");;
        }else{
            System.out.println("Vehicle not found");
        }
    }

    @Override
    public void search() {
        System.out.println("1. Search by Name");
        System.out.println("2. Search by ID");
        int choice = Validation.getInt("Choose: ");

        if(choice == 1){
            String name = Validation.getString("Enter Name: ").toLowerCase();
            ArrayList<Vehicle> foundList = new ArrayList<>();
            for(Vehicle v : this){
                if(v.getName().toLowerCase().contains(name)) foundList.add(v);
            }
            if(foundList.isEmpty()) System.out.println("Not found");
            else{
                Collections.sort(foundList, (v1, v2) -> v2.getName().compareToIgnoreCase(v1.getName()));
                for(Vehicle v : foundList) System.out.println(v);
            }
        }else if(choice == 2){
            String id = Validation.getString("Enter ID: ");
            int index = find(id);
            if(index != -1) System.out.println(this.get(index));
            else System.out.println("Not found");
        }
    }

    @Override
    public void output() {
        System.out.println("1. Show All");
        System.out.println("2. Show Descending by Price");
        int choice = Validation.getInt("Choose: ");

        if(this.isEmpty()){
            System.out.println("List empty");
            return;
        }

        if(choice == 1){
            for(Vehicle v : this) System.out.println(v);
        }else if(choice == 2){
            ArrayList<Vehicle> clone = (ArrayList<Vehicle>) this.clone();
            Collections.sort(clone, (v1, v2) ->Integer.compare(v2.getPrice(), v1.getPrice()));
            for(Vehicle v : clone) System.out.println(v);
        }
    }

    @Override
    public int find(String code) {
        return this.indexOf(new Car(code));
    }

    @Override
    public void readFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vehicle_file.txt"))){
            ArrayList<Vehicle> data = (ArrayList<Vehicle>) ois.readObject();
            this.clear();
            this.addAll(data);
            System.out.println("Loaded " + data.size() + " vehicles from file");
            output();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    @Override
    public void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vehicle_file.txt"))){
            oos.writeObject(this);
            System.out.println("Saved success");
        }catch (Exception e) {
            System.out.println("Save Failed");
            e.printStackTrace();
        }
    }
}
