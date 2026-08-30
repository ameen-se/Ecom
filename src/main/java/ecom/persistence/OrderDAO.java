package ecom.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import ecom.entities.ProductOrder;
import ecom.entities.RequestOrder;

@Component
public interface OrderDAO {

    void saveOrder(int userId, RequestOrder requestOrder);

    List<ProductOrder> getOrdersByUser(int userId);

    ProductOrder orderStatusUpdate(int id, String status);

    List<ProductOrder> getAllOrdersByUser();
}
