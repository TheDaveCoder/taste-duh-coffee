package Models;

public class Sale {
    private int invoiceID;
    private int productID;
    private String sizeName;
    private Double unitPrice;
    private int quantity;
    private Double amount;

    public Sale(int invoiceID, int productID, String sizeName, Double unitPrice, int quantity, Double amount) {
        this.invoiceID = invoiceID;
        this.productID = productID;
        this.sizeName = sizeName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    public int getProductID() {
        return productID;
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
}
