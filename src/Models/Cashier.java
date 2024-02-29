package Models;

public class Cashier {
    private int id;
    private String username;
    private String password;

    public Cashier(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {return password; }
}
