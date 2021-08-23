package mx.tec.lab.manager;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import mx.tec.lab.entity.Product;
import mx.tec.lab.entity.Sku;
import mx.tec.lab.repository.ProductRepository;

/**
 * The Product Manager with all methods that access the DB Directly
 * @author victorg
 *
 */

@Service
public class ProductManager {

	@Resource
	/**
	 * Object that connects to the database
	 */
	ProductRepository productRepo;
	/**
	 * ProductManager object empty Constructor
	 */
	public ProductManager() {
	/*
	 * Empty Constructor 
	 */
	}
	/** * Retrieve all the products saved in the database 
	 * * 
	 * * @return List with all the products
	 * */ 
	public List<Product> getProducts() {
		return productRepo.findAll();
	}
	
	/** * Retrieve an specific product based on a given product id 
	 * * @param String: Pattern to search with 
	 * * @return List<Product>: A list with all the Products whose names are like Pattern 
	 * */ 
	public List<Product> getProducts(final String pattern) {
		return productRepo.findByNameLike(pattern); 
	} 
	/**
	 * Retrieve a specific product by id
	 * @param long: the ID to be searched.
	 * @return Optional<Product>: Returns the object that was found, wrapped inside an Optional.
	 */
	public Optional<Product> getProduct(final long id) {
		return productRepo.findById(id);
	} 
	
	/**
	 * Delete a specific object from the database
	 * @param existingProduct: The product object to find and delete
	 * @return void
	 */
	public void deleteProduct(final Product existingProduct) {
		
		productRepo.delete(existingProduct);
		
	}
	/**
	 * Update a specific product from the database
	 * @param id: the identificator of the product to update
	 * @param replacement: the modified version of the product to be saved
	 * @return void
	 */
	public void setProduct(final long id, final Product replacement) {
		if (replacement.getId() == id) {
			for (final Sku modifiedSku : replacement.getChildSkus()) {
				modifiedSku.setParentProduct(replacement);
				} 
			productRepo.save(replacement); 
			}
	} 

	/**
	 * Method to save a product to the repository
	 * @param newProduct
	 * @return Product: the saved product
	 */
	public Product addProduct(final Product newProduct) {
		for(final Sku newSku : newProduct.getChildSkus()) {
			newSku.setParentProduct(newProduct);
		}
		return productRepo.save(newProduct);
	}
}
