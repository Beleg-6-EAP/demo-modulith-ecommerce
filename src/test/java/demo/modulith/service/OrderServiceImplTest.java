package demo.modulith.service;

import demo.modulith.order.OrderService;
import demo.modulith.order.internal.Order;
import demo.modulith.order.internal.OrderRepository;
import demo.modulith.order.internal.OrderServiceImpl;
import demo.modulith.payment.PaymentService;
import demo.modulith.shipment.ShipmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private PaymentService paymentService;

    @Mock
    private ShipmentService shipmentService;

    @Test
    void should_PersistOrder_When_CreatingOrder() {
        final Order order = mkDummyOrder();
        when(orderRepository.save(order)).thenReturn(order);

        orderService.create(order);

        verify(orderRepository, atLeastOnce()).save(order);
    }

    @Test
    void should_ProcessPayment_ExactlyOnce_When_CreatingOrder() {
        final Order order = mkDummyOrder();
        when(orderRepository.save(order)).thenReturn(order);

        orderService.create(order);

        verify(paymentService, times(1)).processPayment(any());
    }

    @Test
    void should_HandleShipping_ExactlyOnce_When_CreatingOrder() {
        final Order order = mkDummyOrder();
        when(orderRepository.save(order)).thenReturn(order);

        orderService.create(order);

        verify(shipmentService, times(1)).handleShipping(any());
    }

    private Order mkDummyOrder() {
        return new Order(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                42d,
                "ORDERED"
        );
    }
}
