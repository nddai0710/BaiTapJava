package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BorrowList extends ArrayList<Borrow> {
    private static final String FILE = "borrow.dat";
    public BorrowList() {load();}

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(new ArrayList<>(this));
        }catch (Exception e){}
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            this.addAll((ArrayList<Borrow>) ois.readObject());
        }catch (Exception e){}
    }
}
