package demo.modulith.order;

import demo.modulith.order.internal.Order;
import demo.modulith.order.internal.OrderRepository;
import demo.modulith.payment.internal.PaymentServiceImpl;
import demo.modulith.shipment.internal.ShipmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    List<Order> getAll();
}
