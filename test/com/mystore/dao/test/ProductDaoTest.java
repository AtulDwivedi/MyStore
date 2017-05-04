package com.mystore.dao.test;

import com.mystore.dao.service.impl.ProductDaoImpl;
import com.mystore.model.Product;

public class ProductDaoTest {

	public static void main(String[] args) {
		Product prod = new Product();
		ProductDaoImpl product = new ProductDaoImpl();
		prod.setProductId("P2");
		prod.setProductName("LG LED 36L");
		prod.setCategory("TV");
		prod.setDescription("Live TV");
		prod.setSpecifications("36 inch, 4 speakers");
		prod.setQuantityInStock(2);
		prod.setPrice(39999);

		int rowsAffected = product.saveProduct(prod);
		System.out.println(rowsAffected + "row(s) inserted into STR_PRODUCT");
		//System.out.println(product.updateProduct(prod) + "row(s) updated successfully");
		//System.out.println(product.deleteProductByProductId("P2") + "row(s) deleted successfully");
	}

}
