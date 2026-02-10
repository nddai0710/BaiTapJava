package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AssetList extends ArrayList<Asset> {
    private static final String FILE = "asset.dat";
    public AssetList() {load();}

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            this.addAll((ArrayList<Asset>) ois.readObject());
        }catch (Exception e){}
    }

    public void save() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))){
            oos.writeObject(new ArrayList<>(this));
        }catch (Exception e){e.printStackTrace();}
    }

    public Asset findByID(String id) {
        for (Asset a : this) if (a.getId().equalsIgnoreCase(id)) return a;
        return null;
    }
}
