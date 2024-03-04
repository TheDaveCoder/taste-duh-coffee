package Models;

public class Invoice {
    private int invoiceID;
    private String invoiceDate;
    private int cashierID;
    private String cashierName;
    private double subtotal;
    private double totalAmount;

    public Invoice(int invoiceID, String invoiceDate, int cashierID, String cashierName, double subtotal, double totalAmount) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.cashierID = cashierID;
        this.cashierName = cashierName;
        this.subtotal = subtotal;
        this.totalAmount = totalAmount;
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    public String getInvoiceDate() {
        return invoiceDate;
    }
    public int getCashierID() {
        return cashierID;
    }
    public String getCashierName() {
        return cashierName;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
}

