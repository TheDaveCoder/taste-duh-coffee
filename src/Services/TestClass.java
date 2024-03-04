package Services;

import Models.Cashier;
import Models.Invoice;
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
        if (existingCashier != null) {
            System.out.println(existingCashier.getUsername() + " " + existingCashier.getPassword());
        } else {
            System.out.println("Doesn't Exist!");
        }

        // Register Tests
        // ----------------
        // Check for Match
        // Arguments accepted are the last name and the user name
        if (AccountManager.checkForMatch("lname2", "pesch")) {
            System.out.println("account already exists!");
        } else {
            System.out.println("account doesn't exist!");
        }
        // Upload account details to Database
//        String lastname = "dubois";
//        String username = "Tom";
//        String password = "12345";
//        AccountManager.recordNewUser(lastname, username, password);

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
//        ArrayList<Sale> sales = new ArrayList<>();
//        sales.add(new Sale(
//                5, 12, "Small", 85.00, 2, 170.00
//        ));
//        sales.add(new Sale(
//                5, 19, "Medium", 65.00, 3, 195.00
//        ));
//        OrderManager.recordSale(sales);

        //Get Invoices
        //--------------
        // Latest
        Invoice inv1 = OrderManager.getInvoiceLatest();
        System.out.println(inv1.getInvoiceID() + " " +
                inv1.getInvoiceDate() + " " +
                inv1.getCashierID() + " " +
                inv1.getCashierName() + " " +
                inv1.getSubtotal() + " " +
                inv1.getTotalAmount());
        // All of them
        ArrayList<Invoice> inv2 = OrderManager.getInvoiceAll();
        for( Invoice ob :inv2) {
            System.out.println(ob.getInvoiceID() + " " +
                    ob.getInvoiceDate() + " " +
                    ob.getCashierID() + " " +
                    ob.getCashierName() + " " +
                    ob.getSubtotal() + " " +
                    ob.getTotalAmount());
        }
        // Test Sale Object
//        Sale saleExamp = new Sale(5, 12, "Small", 85d, 2, 170d);
//        System.out.println(saleExamp.getQuantity());
//        System.out.println(saleExamp.getAmount());
//        saleExamp.setQuantity(5);
//        saleExamp.setAmount(5);
//        System.out.println(saleExamp.getQuantity());
//        System.out.println(saleExamp.getAmount());

        // Delete Invoice
//        OrderManager.deleteInvoice(11);

        // Get singular invoice by ID
//        System.out.println(OrderManager.getInvoiceByID(26).getTotalAmount());
    }
}

