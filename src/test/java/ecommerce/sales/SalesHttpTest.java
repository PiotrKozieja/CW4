package ecommerce.sales;

import ecommerce.catalog.ProductCatalog;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHttpTest {
    @Autowired
    TestRestTemplate http;
    @LocalServerPort
    private int port;
    @Autowired
    ProductCatalog catalog;

    private String thereIsExampleProduct(String name, BigDecimal price) {
        var id = catalog.addProduct(name, name);
        catalog.changePrice(id, price);
        return "productX";
    }
    @Test
    void itAllowToAcceptOffer(){
        //ARRANGE
        String productId = thereIsExampleProduct("Example Product", BigDecimal.valueOf(10.10));

        //ACT
        //add product to cart
        String addProductToCartURL = String.format("http://localhost:%s/%s/%s",
                port,
                "api/add-to-cart",
                productId);

        ResponseEntity<Object> addProductResponse = http.postForEntity(
                addProductToCartURL, null,Object.class);

        //accept offer
        String acceptOfferUrl = String.format(
                "http://localhost:%s/%s",
                port,
                "api/accept-offer"
        );
        AcceptOfferRequest acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("Piotr")
                .setLastName("Kozieja")
                .setEmail("example@example.com");

        ResponseEntity<ReservationDetail> reservationDetailResponseEntity =http.postForEntity(
                acceptOfferUrl, null, ReservationDetail.class);

        //Arrange
        //-> reservationWithIdExists
        //->thereIsPaymentURLAvailable

        assertEquals(reservationDetailResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(reservationDetailResponseEntity.getBody().getPaymentUrl());
        assertEquals(BigDecimal.valueOf(10.10),reservationDetailResponseEntity.getBody().getTotal());
    }

}
