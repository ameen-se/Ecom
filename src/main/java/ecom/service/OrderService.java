package ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecom.entities.ProductOrder;
import ecom.entities.RequestOrder;

@Service
public interface OrderService {

    public void saveOrder(int userId, RequestOrder requestOrder) throws Exception;

    public List<ProductOrder> getOrdersByUser(int userId);

    public ProductOrder orderStatusUpdate(int id, String status);

    public List<ProductOrder> getAllOrdersByUser();
}
