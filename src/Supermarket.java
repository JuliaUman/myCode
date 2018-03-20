

import java.util.ArrayList;
import java.util.List;

public class Supermarket {
 List <Product> products = new ArrayList();
 List <Product> sales = new ArrayList();

 public void addProduct(String productName, double price, long barCode) {
     products.add(new Product(productName, price, barCode));
 }
 //public double scanProduct(long barCode) {
    // for(long i = 0; i < products.size(); i++) {
       //  Product product = new Product();
       //  if(barCode == product.barCode){
//
  //       }return product.price;
     //}
    // return 0;
 //}
  public void addspecialPrice(String productName, double specialPrice, int amount) {
     sales.add(new Product(productName, specialPrice, amount));
        }

    public double specialSales(String productName, int amount) {
        for(int i = 0; i < sales.size(); i++) {
            Product product = new Product();
            if(productName.equals(product.productName)){
                if(amount == product.amount) {

            }return product.specialPrice;
        }

}
        return 0;
    }
}

