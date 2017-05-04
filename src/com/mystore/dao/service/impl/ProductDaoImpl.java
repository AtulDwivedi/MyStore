package com.mystore.dao.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mystore.dao.service.ProductDao;
import com.mystore.dao.service.util.ConnectionProvider;
import com.mystore.model.Customer;
import com.mystore.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int saveProduct(Product product) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO STR_PRODUCT VALUES(?,?,?,?,?,?,?)")) {
			
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getCategory());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getSpecifications());
			ps.setInt(6, product.getQuantityInStock());
			ps.setDouble(7, product.getPrice());
			
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	
	}
	@Override
	public int updateProduct(Product product) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE STR_PRODUCT SET PRODUCTNAME=?, CATEGORY=?, DESCRIPTION=?, SPECIFICATIONS=?, QUANTITYINSTOCK=?, PRICE=? WHERE PRODUCTID=?")) {
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getCategory());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getSpecifications());
			ps.setInt(5, product.getQuantityInStock());
			ps.setDouble(6, product.getPrice());
			ps.setString(7, product.getProductId());

			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public int deleteProductByProductId(String productId) {
		int retVal = 0;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM STR_PRODUCT WHERE PRODUCTID = ?")) {
			ps.setString(1, productId);
			retVal = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	@Override
	public Product getProductByProductId(String productId) {
		Product prod = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_PRODUCT WHERE PRODUCTID = ?")) {
			ps.setString(1, productId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(prod == null){
					prod = new Product();
				}
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setCategory(rs.getString(3));
				prod.setDescription(rs.getString(4));
				prod.setSpecifications(rs.getString(5));
				prod.setQuantityInStock(rs.getInt(6));
				prod.setPrice(rs.getDouble(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prod;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM STR_PRODUCT")) {
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Product prod = new Product();
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setCategory(rs.getString(3));
				prod.setDescription(rs.getString(4));
				prod.setSpecifications(rs.getString(5));
				prod.setQuantityInStock(rs.getInt(6));
				prod.setPrice(rs.getDouble(7));
				products.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public int importProducts(List<Product> products)
	{
		int retVal = 0;
		return retVal;
	}
	
	@Override
	public void exportProducts()
	{
		
	}
	

}
