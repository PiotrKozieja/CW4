package ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class ProductCatalogTest {
    @Test
    void itAllowsListingProducts(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assert products.isEmpty();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
    @Test
    public void itAllowsToAddProduct(){
        ProductCatalog newProductCatalog = new ProductCatalog();
        newProductCatalog.addProduct("Lego zestaw 8080","The best one");
        List<Product> allProducts = newProductCatalog.allProducts();
        assertThat(allProducts).hasSize(1);

    }
    @Test
    public void itLoadsSingleProductById(){
        ProductCatalog newProductCatalog = new ProductCatalog();
        String id = newProductCatalog.addProduct("Lego zestaw 8080","The best one");
        Product loaded = newProductCatalog.getProductById(id);
        assertThat(loaded.getId().equals(id));
    }
    @Test
    public void itAllowsChangePrice(){
        ProductCatalog newProductCatalog = new ProductCatalog();
        String id = newProductCatalog.addProduct("Lego zestaw 8080","The best one");
        newProductCatalog.ChangePrice(id, BigDecimal.valueOf(100.1));
        assertThat(newProductCatalog.getProductById(id).getPrice().equals(BigDecimal.valueOf(100)));
    }

}
