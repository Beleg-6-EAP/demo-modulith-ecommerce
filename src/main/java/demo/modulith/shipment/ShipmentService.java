package demo.modulith.shipment;

import demo.modulith.shipment.internal.Shipment;
import demo.modulith.shipment.internal.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ShipmentService {

    void handleShipping(String orderId);

    List<Shipment> getAll();
}
