package model;

public class Product {
   private final String productName;
   private final String productCategory;
   private final double price;
   private int quantity;

    public Product(String productName, String productCategory, double price, int quantity) {
       this.productName = productName;
       this.productCategory = productCategory;
       this.price = price;
       this.quantity = quantity;
   }

    public String getProductName() {return productName;}

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
