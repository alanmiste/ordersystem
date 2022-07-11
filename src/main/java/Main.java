import model.ordersystem.ShopService;
import model.ordersystem.shop.product.Product;
import model.ordersystem.shop.product.ProductRepo;

public class Main {

    public static void main(String[] args) {


        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(ProductRepo);

        Product product = shopService.getProduct(3);

        System.out.println(product);

    }
}
