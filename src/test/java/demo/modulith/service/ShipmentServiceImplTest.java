package demo.modulith.service;

import demo.modulith.shipment.internal.Shipment;
import demo.modulith.shipment.internal.ShipmentRepository;
import demo.modulith.shipment.internal.ShipmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ShipmentServiceImplTest {

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @Mock
    private ShipmentRepository shipmentRepository;

    @Test
    void should_PersistShipment_When_HandlingShipping() {
        final String uuid = UUID.randomUUID().toString();

        shipmentService.handleShipping(uuid);

        verify(shipmentRepository, atLeastOnce()).save(any(Shipment.class));

    }
}
