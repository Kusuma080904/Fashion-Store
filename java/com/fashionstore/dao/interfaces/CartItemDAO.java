package com.fashionstore.dao.interfaces;

import com.fashionstore.model.CartItem;
import java.util.List;

public interface CartItemDAO {
    boolean addItem(CartItem item);
    boolean updateQuantity(int itemId, int quantity);
    boolean removeItem(int itemId);
    boolean clearCart(int cartId);
    List<CartItem> getItemsByCartId(int cartId);
    CartItem getItem(int cartId, int productId);
}