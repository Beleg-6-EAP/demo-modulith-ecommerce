package demo.modulith.order;

import demo.modulith.order.internal.Order;
import demo.modulith.order.internal.OrderRepository;
import demo.modulith.payment.PaymentService;
import demo.modulith.shipment.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final ShipmentService shipmentService;

    public Order create(Order order) {
        final Order savedOrder = orderRepository.save(order);
        paymentService.processPayment(savedOrder.getId());
        shipmentService.handleShipping(savedOrder.getId());

        return savedOrder;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
