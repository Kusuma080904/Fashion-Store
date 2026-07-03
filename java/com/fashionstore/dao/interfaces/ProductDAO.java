package com.fashionstore.dao.interfaces;

import com.fashionstore.model.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(int categoryId);
    Product getProductById(int id);
    List<Product> searchProducts(String query);
    List<Product> filterProducts(Integer categoryId, String brand, Double minPrice, Double maxPrice, String sort);
    boolean updateStock(int productId, int quantity);
    boolean restoreStock(int productId, int quantity);
}