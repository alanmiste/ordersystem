package model.ordersystem;

import model.ordersystem.shop.product.Product;
import model.ordersystem.shop.product.ProductRepo;

public class ShopService {
    private  ProductRepo productRepo;


    public ShopService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }
}
