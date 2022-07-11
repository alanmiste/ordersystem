package model.ordersystem.shop.order;

import model.ordersystem.shop.product.Product;

import java.util.List;

public record Order(
        int id,
        List<Product> products
) {
}