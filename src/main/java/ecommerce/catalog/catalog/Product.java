package ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product{

    private final UUID id;
    private final String name;
    private final String description;




    private BigDecimal price;

    public Product(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getId(){
        return id.toString();
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return price;
    }
}
