package model.ordersystem;

import model.ordersystem.shop.order.Order;
import model.ordersystem.shop.order.OrderRepo;
import model.ordersystem.shop.product.Product;
import model.ordersystem.shop.product.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

class ShopServiceTest {

    @Test
    void getProduct() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //when
        Product actual = shopService.getProduct(2);

        //then
        assertThat(actual).isEqualTo(new Product(2, "Banane"));
    }

    @Test
    void listProducts() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //when
        List<Product> actual = shopService.listProducts();

        //then
        List<Product> expected = List.of(
                new Product(1, "Apfel"),
                new Product(2, "Banane"),
                new Product(3, "Zitrone"),
                new Product(4, "Mandarine")
        );
        assertThat(actual)
                .hasSameElementsAs(expected)
                .hasSize(expected.size());
    }

    @Test
    void addAndGetOrder() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //when
        shopService.addOrder(106, List.of(1, 3, 4));
        Order actual = shopService.getOrder(106);

        //then
        assertThat(actual)
                .isEqualTo(
                        new Order(
                                106,
                                List.of(
                                        new Product(1, "Apfel"),
                                        new Product(3, "Zitrone"),
                                        new Product(4, "Mandarine")
                                )
                        )
                );
    }

    @Test
    void addAndListOrders() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //when
        shopService.addOrder(106, List.of(1, 3, 4));
        List<Order> actual = shopService.listOrders();

        //then
        List<Order> expected = List.of(
                new Order(
                        106,
                        List.of(
                                new Product(1, "Apfel"),
                                new Product(3, "Zitrone"),
                                new Product(4, "Mandarine")
                        )
                )
        );
        assertThat(actual)
                .hasSameElementsAs(expected)
                .hasSize(expected.size());
    }


}