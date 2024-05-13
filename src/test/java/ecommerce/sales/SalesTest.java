package ecommerce.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTest {
    @Test
    void itAllowsToAddProductToCart(){
        var customerId = thereIsExampleCustomer();
        var productId = thereIsProduct("product", BigDecimal.valueOf(10));

        SalesFacade sales = thereIsSalesFacade();

        sales.addToCart(customerId, productId);

        Offer offer = sales.getCurrentOffer(customerId);
        assertEquals(BigDecimal.valueOf(10), offer.getTotal());
        assertEquals(1, offer.getItemsCount());

    }
    @Test
    void itAllowToAddMultipleProductsToCart(){
        var customerA = thereIsCustomer("Piotr");
        var productA = thereIsProduct("product a",BigDecimal.valueOf(10));
        var productB = thereIsProduct("product b",BigDecimal.valueOf(20));
        SalesFacade sales = thereIsSalesFacade();
        //Act
        sales.addToCart(customerA, productA);
        sales.addToCart(customerA, productB);
        //ASSERT
        Offer currentOfferA = sales.getCurrentOffer(customerA);
        assertEquals(BigDecimal.valueOf(30), currentOfferA.getTotal());


    }
    @Test
    void itShowsCurrentOffer(){
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsCustomer("Piotr");
        Offer offer = sales.getCurrentOffer(customerId);
        assertEquals(0,offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }
    @Test
    void itDoesNotShareCustomersCarts(){
        var customerA = thereIsCustomer("Piotr");
        var customerB = thereIsCustomer("Michal");
        var productA = thereIsProduct("product a", BigDecimal.valueOf(10));
        var productB = thereIsProduct("product b", BigDecimal.valueOf(20));

        SalesFacade sales = thereIsSalesFacade();

        sales.addToCart(customerA, productA);
        sales.addToCart(customerB, productB);

        Offer offerA = sales.getCurrentOffer(customerA);
        assertEquals(BigDecimal.valueOf(10), offerA.getTotal());

        Offer offerB = sales.getCurrentOffer(customerB);
        assertEquals(BigDecimal.valueOf(20), offerB.getTotal());

    }

    private String thereIsCustomer(String name) {return name;}
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
    private String thereIsProduct(String name, BigDecimal price) {
        return name;
    }


}
