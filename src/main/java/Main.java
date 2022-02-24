import application.ApplicationImpl;
import enums.Designation;
import enums.Gender;
import enums.Qualification;
import exceptions.*;
import model.*;
import operations.AdminOperationImpl;
import operations.AdminOperations;
import recruitment.RecruitmentImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InsufficientFundException, OutOfStockException, ApplicantAlreadyAppliedException, NotTheExactQuantityException, CustomerNotCheckedOutException, NotQualifiedException, StaffNotAuthorizedException, IOException {
        AdminOperations adminOperations = new AdminOperationImpl();
//        CustomerImpl customerOperations = new CustomerImpl();
        ApplicationImpl applicationImpl = new ApplicationImpl();
        RecruitmentImpl recruitmentImpl = new RecruitmentImpl();
        Applicant charles = new Applicant("charles","john","106PARK",Gender.MALE, Qualification.BSC);

        Store hugoBoss = new Store("hugoBoss");
        Staff manager = new Staff("John", "Boss", Gender.MALE, Designation.MANAGER);
        Staff cashier = new Staff("John", "Boy", Gender.MALE, Designation.CASHIER);
        Customer ugo = new Customer("Ugonna", "Chukwu", Gender.MALE, 800000);
        Product macBookPro = new Product("MacBook pro","Laptop",250000.00,30);


        adminOperations.addProductsToStore(hugoBoss, manager, "src/main/resources/excelFiles/hugo_store.xlsx");
//        System.out.println(Arrays.toString(hugoBoss.getStocks()));
//        System.out.println(hugoBoss.getStocks());

        for (int i = 0; i < hugoBoss.getStocks().size(); i++){
            System.out.println(hugoBoss.getStocks().get(i));
        }
  //      applicationImpl.apply(charles,hugoBoss);   //apply to store
  //      System.out.println(hugoBoss.getApplicants());

//        hugoBoss.getListOfStaffs().put(john);    //manager hiring cashier
   //     recruitmentImpl.singleHire(charles,john,hugoBoss);
  //      System.out.println(hugoBoss.getListOfStaffs());
//
//        hugoBoss.getStocks().put(SamsungInfinix,10);
//        customerOperations.addToCart(hugoBoss, ugo,macBookPro,5); //put to cart
//
//        customerOperations.removeFromCart(ugo,macBookPro , 3); // remove from cart
//        System.out.println("ugo's cart "+ugo.getCart());

//
//        customerOperations.buyProduct(ugo);    //buy product
//        adminOperations.sellProduct(cashier,ugo);



//
//
//




//        hugoBoss.getStocks();
//        System.out.println(hugoBoss.getStocks());
//        System.out.println(hugoBoss.getListOfStaffs());
//

    }
}
