package data;

import java.io.Serializable;

public class Employee implements Serializable {
    private String id, name, role, password;

    public Employee(String id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getPassword() { return password; }
}