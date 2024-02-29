package Services;

import Models.Cashier;
import Models.Sale;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestClass {
    public static void main(String[] args) {

        // Login Test
        // ----------------
        // Argument accepted is the username
        Cashier existingCashier = AccountManager.getUserByUsername("joe");
        if(existingCashier != null) {
            System.out.println(existingCashier.getUsername() + " " + existingCashier.getPassword());
        } else {
            System.out.println("Doesn't Exist!");
        }

        // Register Tests
        // ----------------
        // Check for Match
        // Arguments accepted are the last name and the user name
        if(AccountManager.checkForMatch("lname2", "pesch")) {
            System.out.println("account already exists!");
        } else {
            System.out.println("account doesn't exist!");
        }
        // Upload account details to Database
        String lastname = "dubois";
        String username = "Tom";
        String password = "12345";
        AccountManager.recordNewUser(lastname, username, password);

        // Order Finalization
        // ----------------
        // Upload Invoice details to Database
        // Arguments accepted are the current timestamp, cashierID, subtotal, and total amount
        Date currDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(currDate);
        OrderManager.recordInvoice(currentTime, 3, 204.5, 250.75);
        // Upload Sales into Database
        // Argument accepted is an arraylist with the generic `sale`
        ArrayList<Sale> sales = new ArrayList<>();
        sales.add(new Sale(
                1, 12, "Small", 85.00, 2, 170.00
        ));
        sales.add(new Sale(
                1, 42, "Medium", 65.00, 3, 195.00
        ));
        OrderManager.recordSale(sales);
    }
}
