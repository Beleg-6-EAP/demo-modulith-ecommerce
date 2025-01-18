package demo.modulith.shipment;

import demo.modulith.shipment.internal.Shipment;
import demo.modulith.shipment.internal.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public void handleShipping(String orderId) {
        final Shipment shipment = new Shipment(UUID.randomUUID().toString(), orderId, UUID.randomUUID().toString());
        shipmentRepository.save(shipment);
    }

    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }
}
