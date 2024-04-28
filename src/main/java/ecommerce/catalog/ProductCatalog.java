package ecommerce.catalog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import  java.util.*;

import static java.util.Arrays.stream;

public class ProductCatalog {
    ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {return productStorage.allProducts();}

    public String addProduct(String name, String description){
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id,name,description);
        productStorage.addProduct(newProduct);
        return id.toString();
    }
    public Product getProductById(String id){return  productStorage.getProductBy(id);}
    public void changePrice(String id, BigDecimal price){
        Product loadedProduct = getProductById(id);
        loadedProduct.setPrice(price);
    }
}
