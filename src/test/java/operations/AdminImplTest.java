package operations;

import enums.Designation;
import enums.Gender;
import exceptions.InsufficientFundException;
import exceptions.OutOfStockException;
import exceptions.StaffNotAuthorizedException;
import model.Customer;
import model.Staff;
import model.Store;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AdminImplTest {
    Store ugoBossStore = new Store("Decagon");
    Customer ugo = new Customer("ugo","Eze", Gender.MALE,500);
    AdminOperationImpl adminOperationImpl;
    CustomerOperationImpl customerImpl;
    Staff  cashier = new Staff("Damilola", "Obinna", Gender.MALE, Designation.CASHIER);
    Staff  manager = new Staff("Chukuka", "Ebuka", Gender.MALE, Designation.MANAGER);
    String excelFilePath = "src/main/resources/excelFiles/hugo_store.xlsx";
    Customer customer = new Customer("ugo","Eze", Gender.MALE,15_000_000.00);

    @Before
    public void setUp(){
        customerImpl = new CustomerOperationImpl();
        adminOperationImpl = new AdminOperationImpl();
    }

    @Test
    public void storeShouldHaveQuantityOfGoods() throws StaffNotAuthorizedException, IOException {
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        assertEquals(6, ugoBossStore.getStocks().size());
    }

    @Test
    public void storeShouldContainGoods() throws StaffNotAuthorizedException, IOException {
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        assertTrue(ugoBossStore.getStocks().contains("MacBook pro"));
        assertTrue(ugoBossStore.getStocks().contains("Tecno Camera"));
    }

    @Test
    public void customerCartShouldNotContainProductAfterPurchase() throws StaffNotAuthorizedException, InsufficientFundException, OutOfStockException, IOException {
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        customerImpl.addToCart(ugoBossStore, customer, "MacBook pro", 5);
        adminOperationImpl.sellProduct(ugoBossStore, cashier, customer);
        assertTrue(customer.getCart().isEmpty());
    }

    @Test
    public void testForUnAuthorisedAddingToCompanyStock(){
        assertThrows(StaffNotAuthorizedException.class, ()->adminOperationImpl.addProductsToStore(ugoBossStore, cashier, excelFilePath));
    }

    @Test
    public void testForUnAuthorisedSellingOfProducts() throws StaffNotAuthorizedException, OutOfStockException, IOException {
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        customerImpl.addToCart(ugoBossStore, customer, "MacBook pro", 5);
        assertThrows(StaffNotAuthorizedException.class, ()->adminOperationImpl.sellProduct(ugoBossStore, manager, customer));
    }

    @Test
    public void shouldThrowInsufficientFundException() throws StaffNotAuthorizedException, OutOfStockException, IOException {
        Customer customer2 = new Customer("Chisom", "Ayuba", Gender.MALE, 4_000);
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        customerImpl.addToCart(ugoBossStore, customer2, "MacBook pro", 5);
        assertThrows(InsufficientFundException.class, ()->adminOperationImpl.sellProduct(ugoBossStore, cashier, customer2));
    }

    @Test
    public void staffCanSeeGoodsByCategory() throws StaffNotAuthorizedException {
        adminOperationImpl.addProductsToStore(ugoBossStore, manager, excelFilePath);
        assertEquals( 2, adminOperationImpl.viewProductByCategory(ugoBossStore, "Laptops").size());
        assertEquals( "Laptops", adminOperationImpl.viewProductByCategory(ugoBossStore, "Laptops").get(0).getProductCategory());
        assertEquals( "Phones", adminOperationImpl.viewProductByCategory(ugoBossStore, "Phones").get(1).getProductCategory());
    }
}