package com.fashionstore.service;

import com.fashionstore.dao.implementations.OrderDAOImpl;
import com.fashionstore.dao.implementations.OrderItemDAOImpl;
import com.fashionstore.dao.implementations.ProductDAOImpl;
import com.fashionstore.dao.interfaces.OrderDAO;
import com.fashionstore.dao.interfaces.OrderItemDAO;
import com.fashionstore.dao.interfaces.ProductDAO;
import com.fashionstore.model.Order;
import com.fashionstore.model.OrderItem;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private ProductDAO productDAO = new ProductDAOImpl();

    public List<Order> getUserOrders(int userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    public Order getOrderDetails(int orderId) {
        return orderDAO.getOrderById(orderId);
    }

    public List<OrderItem> getOrderItems(int orderId) {
        return orderItemDAO.getItemsByOrderId(orderId);
    }

    public boolean cancelOrder(int orderId) {
        Order order = orderDAO.getOrderById(orderId);
        if (order != null && "PLACED".equals(order.getStatus())) {
            // Restore Stock
            List<OrderItem> items = orderItemDAO.getItemsByOrderId(orderId);
            for (OrderItem item : items) {
                productDAO.restoreStock(item.getProductId(), item.getQuantity());
            }
            orderDAO.updateStockRestored(orderId, true);
            
            return orderDAO.updateStatus(orderId, "CANCELLED");

        }
        return false;
    }
}