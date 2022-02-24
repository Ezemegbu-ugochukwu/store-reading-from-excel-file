package operations;

import exceptions.NotTheExactQuantityException;
import exceptions.OutOfStockException;
import model.Customer;
import model.Store;

public class CustomerOperationImpl implements CustomerOperations{

    public void addToCart(Store store, Customer customer, String productName, int quantity) throws OutOfStockException {
        if (!store.getStocks().contains(productName)) throw new OutOfStockException("We are currently out of " + productName);
        if (store.getStocks().get(productName).getQuantity() < quantity) throw new OutOfStockException("Company has limited quantity of desired product!");
        customer.getCart().merge(productName, quantity, Integer::sum);
    }

    @Override
    public void removeFromCart(Customer customer, String productName, int quantity) throws NotTheExactQuantityException {
        if (customer.getCart().get(productName) < quantity) throw new NotTheExactQuantityException("Not the exact quantity of " + productName +".");
        customer.getCart().computeIfPresent(productName, (k, v) -> v - quantity);
    }

}
