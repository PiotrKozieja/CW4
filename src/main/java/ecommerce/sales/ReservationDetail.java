package ecommerce.sales;

import java.math.BigDecimal;

public class ReservationDetail {
    public String getReservationDetail(){
        return "123xyz";
    }
    public String getPaymentUrl() {
        return "http://payment.dev/123xyz";
    }

    public Object getReservationId() {
        return "123xyzz";
    }

    public BigDecimal getTotal() {
        return BigDecimal.valueOf(10);
    }
}
