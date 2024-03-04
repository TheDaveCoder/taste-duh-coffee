package Models;

public class Sale {
    private int invoiceID;
    private int itemID;
    private String productName;
    private String sizeName;
    private Double unitPrice;
    private int quantity;
    private Double amount;

    public Sale(int invoiceID, int itemID, String productName, String sizeName, Double unitPrice, int quantity, Double amount) {
        this.invoiceID = invoiceID;
        this.itemID = itemID;
        this.productName = productName;
        this.sizeName = sizeName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    public int getitemID() {
        return itemID;
    }
    public String getProductName(){
        return productName;
    }
    public String getSizeName() {
        return sizeName;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public Double getAmount() {
        return amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setInvoiceID(int invoiceID) { this.invoiceID = invoiceID; }
}
