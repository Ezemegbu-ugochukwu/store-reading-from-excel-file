package model;

import java.util.Arrays;

public class Stocks {
    private Product [] products = new Product[0];

    public void put(Product product){
        Product [] temp = products.clone();
        products = new Product [products.length + 1];
        System.arraycopy(temp, 0, products, 0, products.length - 1);
        products[products.length- 1] = product;
    }

    public boolean contains(String productName){
        for(Product good : products)
            if(good.getProductName().equals(productName)) return true;
        return false;
    }

    public Product get(String productName){
        for (Product product : products)
            if(product.getProductName().equals(productName)) return product;
        return null;
    }

    public Product get(int index){
        return products[index];
    }

    public int size(){
        return products.length;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
