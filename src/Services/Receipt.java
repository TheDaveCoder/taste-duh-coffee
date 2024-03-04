import java.util.ArrayList;

/**
 *
 * @author joshu
 */
public class Receipt {
    static String time = "8:52:22 PM";
    static String date = "Thursday, 21-07-2022";
    static int purchaseID = 1;
    static String filler = " ";
    static Object[][] prod = {
            {"Cold Coffee", 1, 6.0, 6.0},
            {"Cappuccino Coffee", 2, 1.0, 30.0},
            {"Fruits Cake", 3, 243.0, 72.0}
    };
    static double tax = 15.0;
    static double subTotal = 225.8;
    static double total = 240.8;

    public static void main(String[] args) {
        System.out.format("*****************Taste The Coffee*****************\n"
                        + "Time: %s  Date: %s\n"
                        + "Purchase ID: %d\n"
                        + "**************************************************\n"
                        + "Item Name:             \tQty\tPrice($)\tAmount\n"
                        + "1. %-20s\t%-3d\t%-8.2f\t%-6.2f\n"
                        + "2. %-20s\t%-3d\t%-8.2f\t%-6.2f\n"
                        + "3. %-20s\t%-3d\t%-8.2f\t%-6.2f\n"
                        + "**************************************************\n"
                        + "Tax: %.2f\n"
                        + "Sub Total: %.2f\n"
                        + "Total: %.2f\n"
                        + "**************************************************\n"
                , time, date, purchaseID
                , prod[0][0], prod[0][1], prod[0][2], prod[0][3]
                , prod[1][0], prod[1][1], prod[1][2], prod[1][3]
                , prod[2][0], prod[2][1], prod[2][2], prod[2][3]
                , tax, subTotal, total);;

    }
}