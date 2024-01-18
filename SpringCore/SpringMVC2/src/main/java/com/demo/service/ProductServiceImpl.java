package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	 private ProductDao pdao;

	public List<Product> getAllProducts() {
		return pdao.findAllproducts();
	}

	public void addnewProduct(Product p) {
		pdao.save(p);
		
	}

	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	public void updateById(Product product) {
		pdao.modifyProduct(product);
		
	}

	public void deleteById(int id) {
		pdao.removeById(id);
		
	}

}
