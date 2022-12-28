package com.utility.app.service;

import com.utility.app._entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product save2(Product product) throws Exception {
        System.out.println("you are in the save product service , product : "+product.toString());
     if(product.getProductPrice() < 0.0){
         throw new Exception("value of product less than zero");
     }
      product.setProductPrice(123.5);
        return product;
    }
}
