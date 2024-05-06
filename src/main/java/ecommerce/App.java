package ecommerce;

import ecommerce.catalog.ArrayListProductStorage;
import ecommerce.catalog.ProductCatalog;
import ecommerce.sales.SalesController;
import ecommerce.sales.SalesFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Working...");
        SpringApplication.run(App.class,args);
    }
    @Bean
    ProductCatalog createMyProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Lego set 1", "nice one");
        productCatalog.addProduct("Lego set 2", "nice one");
        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade(){
        return new SalesFacade();
    }

}
