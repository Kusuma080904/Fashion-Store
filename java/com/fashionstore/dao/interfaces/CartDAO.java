package com.fashionstore.dao.interfaces;

import com.fashionstore.model.Cart;

public interface CartDAO {
    Cart getCartByUserId(int userId);
    Cart createCart(int userId);
}