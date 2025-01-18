package demo.modulith.payment;

import demo.modulith.payment.internal.Payment;

import java.util.List;

public interface PaymentService {

    void processPayment(String orderId);

    List<Payment> getAll();
}
