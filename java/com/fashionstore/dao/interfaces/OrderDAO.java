package com.fashionstore.dao.interfaces;

import com.fashionstore.model.Order;
import java.util.List;

public interface OrderDAO {
    int createOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
    Order getOrderById(int orderId);
    boolean updateStatus(int orderId, String status);
    boolean updateStockRestored(int orderId, boolean restored);
}