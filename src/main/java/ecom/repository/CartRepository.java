package ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecom.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    public Cart findByProductIdAndUserId(int productId, int userId);

    public Integer countByUserId(int userId);

    public List<Cart> findByUserId(int userId);
}
