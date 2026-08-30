package ecom.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import ecom.entities.Cart;

@Component
public interface CartDAO {

    Cart cartSave(int productId, int userId);

    List<Cart> getCartsByUser(int userId);

    int getCountCart(int userId);

    void updateQuantity(String action, int cartId);
}
