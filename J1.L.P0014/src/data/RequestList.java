package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class RequestList extends ArrayList<Request> {
    private static final String FILE = "request.dat";

    public RequestList() { load(); }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            this.addAll((ArrayList<Request>) ois.readObject());
        } catch (Exception e) {}
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(new ArrayList<>(this));
        } catch (Exception e) {}
    }
}
