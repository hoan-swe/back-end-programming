package com.example.demo.Services;

import com.example.demo.DAO.CartRepository;
import com.example.demo.Entities.Cart;
import com.example.demo.Entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // get the cart info from dto
        Cart cart = purchase.getCart();
        if(purchase.getCartItems().isEmpty()) return new PurchaseResponse("Cart is empty!");

        // generate the tracking number
        String orderTrackingNumber = generateTracking();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate the cart with the cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        // change the cart status to ordered
        cart.setStatus(Cart.Status.ordered);

        // save the cart to the appropriate repository
        cartRepository.save(cart);

        // return the tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateTracking() {
        return UUID.randomUUID().toString();
    }
}
