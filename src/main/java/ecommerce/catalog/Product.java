package ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product{

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Product(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getId(){
        return id.toString();
    }

    public String getName(){return name;}
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal price){this.price = price;}
}
