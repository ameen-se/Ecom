package ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecom.entities.ProductOrder;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByUserId(int userId);
}
