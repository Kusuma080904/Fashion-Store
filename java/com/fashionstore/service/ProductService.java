package com.fashionstore.service;

import com.fashionstore.dao.implementations.CategoryDAOImpl;
import com.fashionstore.dao.implementations.ProductDAOImpl;
import com.fashionstore.dao.implementations.ProductSpecDAOImpl;
import com.fashionstore.dao.interfaces.CategoryDAO;
import com.fashionstore.dao.interfaces.ProductDAO;
import com.fashionstore.dao.interfaces.ProductSpecDAO;
import com.fashionstore.model.Category;
import com.fashionstore.model.Product;
import com.fashionstore.model.ProductSpecification;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private ProductSpecDAO specDAO = new ProductSpecDAOImpl();

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public List<Product> getProductsByCategory(int categoryId) {
        return productDAO.getProductsByCategory(categoryId);
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public List<ProductSpecification> getProductSpecs(int productId) {
        return specDAO.getSpecsByProductId(productId);
    }

    public List<Product> searchProducts(String query) {
        return productDAO.searchProducts(query);
    }

    public List<Product> filterProducts(Integer categoryId, String brand, Double minPrice, Double maxPrice, String sort) {
        return productDAO.filterProducts(categoryId, brand, minPrice, maxPrice, sort);
    }
}