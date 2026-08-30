package ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecom.entities.Cart;

@Service
public interface CartService {

    public Cart cartSave(int productId, int userId);

    public List<Cart> getCartsByUser(int userId);

    public int getCountCart(int userId);

    public void updateQuantity(String action, int cartId);
}
