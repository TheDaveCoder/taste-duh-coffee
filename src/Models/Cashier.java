package Models;

public class Cashier {
    private int id;
    private String lastName;
    private String username;
    private String password;

    public Cashier(int id, String lastName, String username, String password) {
        this.id = id;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getUsername() {
        return username;
    }
    public String getPassword() {return password; }
}
