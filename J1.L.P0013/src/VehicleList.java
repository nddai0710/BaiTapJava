import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class VehicleList {
    ArrayList<Vehicle> list = new ArrayList<>();

    public void loadData(String fName){
        list.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(fName))){
            String line;
            while((line = br.readLine))
        }
    }

    public void saveData(String fName){
        try(PrintWriter pw = new PrintWriter(new FileWriter(fName))){
            for(Vehicle v : list) pw.println(v.toString());
            System.out.println("Saved");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
