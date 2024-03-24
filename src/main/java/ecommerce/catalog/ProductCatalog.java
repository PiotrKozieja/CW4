package ecommerce.catalog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import  java.util.*;

import static java.util.Arrays.stream;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String addProduct(String name, String description){
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id,name,description);
        products.add(newProduct);
        return id.toString();
    }
    public Product getProductById(String id){
        return  products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
    public void ChangePrice(String id, BigDecimal price){
        Product loadedProduct = getProductById(id);
        loadedProduct.setPrice(price);
    }
}
