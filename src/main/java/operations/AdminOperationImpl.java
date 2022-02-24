package operations;

import enums.Designation;
import exceptions.*;
import model.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class AdminOperationImpl implements AdminOperations{

    @Override
    public void addProductsToStore(Store store, Staff staff, String filePath) throws StaffNotAuthorizedException{
        if (!staff.getDesignation().equals(Designation.MANAGER)) throw new StaffNotAuthorizedException("You are not authorized to perform this operation");

            try {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook("src/main/resources/excelFiles/hugo_store.xlsx");
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                store.getStocks().put(new Product(
                        xssfRow.getCell(1).getStringCellValue(),
                        xssfRow.getCell(2).getStringCellValue(),
                        xssfRow.getCell(3).getNumericCellValue(),
                        (int) xssfRow.getCell(4).getNumericCellValue()));
                }
                } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void sellProduct (Store store, Staff staff, Customer customer) throws InsufficientFundException, StaffNotAuthorizedException {
        if(!(staff.getDesignation()  == Designation.CASHIER)) throw new StaffNotAuthorizedException("Only cashier can sell goods!");
            double totalPrice = 0.00;
            for (var products : customer.getCart().entrySet()){
                double productPrice = store.getStocks().get(products.getKey()).getPrice();
                totalPrice += productPrice * products.getValue();
            }
            if (customer.getWalletBalance() < totalPrice) throw new InsufficientFundException("Insufficient fund!");

            for (var products : customer.getCart().entrySet()){
                Product product = store.getStocks().get(products.getKey());
                product.setQuantity(product.getQuantity() - products.getValue());
            }

            customer.getCart().clear();
        }
}
