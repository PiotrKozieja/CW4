package ecommerce.payu;

import ecommerce.payment.PaymentDetails;
import ecommerce.payment.PaymentGateway;
import ecommerce.payment.RegisterPaymentRequest;

public class PayUPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
