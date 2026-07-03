package com.fashionstore.dao.interfaces;

import com.fashionstore.model.OrderItem;
import java.util.List;

public interface OrderItemDAO {
    boolean addOrderItem(OrderItem item);
    List<OrderItem> getItemsByOrderId(int orderId);
}