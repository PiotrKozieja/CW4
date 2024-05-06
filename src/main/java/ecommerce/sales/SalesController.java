package ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;

public class SalesController {
    SalesFacade salesFacade;
    public SalesController(SalesFacade salesFacade){
        this.salesFacade = salesFacade;
    }
    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    private String getCurrentCustomerId() {
        return "Piotr";
    }
}

