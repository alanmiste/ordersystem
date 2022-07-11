package model.ordersystem.shop.product;

import java.util.Map;

public class ProductRepo {
    Map<Integer, Product> products = Map.of(
            1, new Product(1,"Apfel"),
            2, new Product(2,"Banane"),
            3, new Product(3,"Zitrone"),
            4, new Product(4, "Orange")
    );


    public Product getProduct(int id) {
        return products.get(id);
    }
}
