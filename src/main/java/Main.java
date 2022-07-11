import model.ordersystem.ShopService;
import model.ordersystem.shop.order.Order;
import model.ordersystem.shop.order.OrderRepo;
import model.ordersystem.shop.product.Product;
import model.ordersystem.shop.product.ProductRepo;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = shopService.getProduct(3);
        System.out.println(product);

        List<Product> products = shopService.listProducts();
        System.out.println(products);

        shopService.addOrder(101, List.of(2,3));
        shopService.addOrder(102, List.of(1));

        Order order = shopService.getOrder(101);
        System.out.println(order);

        List<Order> orders = shopService.listOrders();
        System.out.println(orders);


        //shopService.addOrder(123, List.of(999));

    }
}