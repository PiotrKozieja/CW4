package ecommerce.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTest {
    @Test
    void itAddProductToCart(){
        SalesFacade sales = thereIsSalesFacade();
    }
    @Test
    void itShowsCurrentOffer(){
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsCustomer("Piotr");
        Offer offer = sales.getCurrentOffer(customerId);
        assertEquals(0,offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private String thereIsCustomer(String name) {
        return name;
    }

    private String thereIsExampleCustomer() {
        return UUID.randomUUID().toString();
    }

    private SalesFacade thereIsSalesFacade(){
        return new SalesFacade();
    }
    @Test
    void itRemoveProdcutFromCart(){

    }
    @Test
    void itAllowToAcceptOffer(){

    }
    @Test
    void itAllowToPayForReservation(){

    }

}
