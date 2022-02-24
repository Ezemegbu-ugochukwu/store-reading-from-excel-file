package operations;

import exceptions.CustomerNotCheckedOutException;
import exceptions.InsufficientFundException;
import exceptions.StaffNotAuthorizedException;
import model.Customer;
import model.Product;
import model.Staff;
import model.Store;

import java.io.IOException;

public interface AdminOperations extends CommonOperations {
    void sellProduct (Store store, Staff cashier, Customer customer) throws InsufficientFundException, CustomerNotCheckedOutException, StaffNotAuthorizedException;
    void addProductsToStore(Store store, Staff staff, String filePath) throws StaffNotAuthorizedException;
}
