package com.mystore.dao.service;

import java.util.List;

import com.mystore.model.Product;

public interface ProductDao {
	
	int saveProduct(Product product);
	int updateProduct(Product product);
	int deleteProductByProductId(String productId);
	
	Product getProductByProductId(String productId);
	List<Product> getProducts();

	int importProducts(List<Product> products);
	void exportProducts();
}
