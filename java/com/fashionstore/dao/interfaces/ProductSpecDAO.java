package com.fashionstore.dao.interfaces;

import com.fashionstore.model.ProductSpecification;
import java.util.List;

public interface ProductSpecDAO {
    List<ProductSpecification> getSpecsByProductId(int productId);
}