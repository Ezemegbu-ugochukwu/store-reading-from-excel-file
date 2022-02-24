package operations;

import model.Product;
import model.Store;

import java.util.ArrayList;
import java.util.List;

public interface CommonOperations {
    default List<Product> viewProductByCategory(Store store, String category){
        List<Product> productArrayList = new ArrayList<>();
            for(int i = 0; i< store.getStocks().size(); i++){
                Product product = store.getStocks().get(i);
                if(product.getProductCategory().equalsIgnoreCase(category))
                    productArrayList.add(product);
            }
            return productArrayList;
    }
}
