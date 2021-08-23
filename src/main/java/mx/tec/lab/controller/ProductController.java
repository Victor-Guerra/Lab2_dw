package mx.tec.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import mx.tec.lab.entity.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.manager.ProductManager;

@RestController
/**
 * Rest Controller for Product queries, handles all rest api routes.
 * @author victorg
 *
 */
public class ProductController {
	@Resource
	/**
	 * Manager Object for Product manipulation
	 */
	private ProductManager productManager;
	
	@GetMapping("/products")
	/**
	 * Method to find all Products in the database
	 * @return ResponseEntity<List<Product>>: The http response entity with a list of all Products found and the http status.
	 */
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	} 

	@GetMapping("/products/{id}")	
	/**
	 * Get a Specific product with an id
	 * @param long: the id with which to find a specific object. It is obtained from the queried path.
	 * @return ResponseEntity<Product>: The http response with the Product found, if any; and the http Status.
	 */
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
			}
		return responseEntity;
		}
	
	@PostMapping("/products")
	/**
	 * Post a new Product object to the database.
	 * @param Product: the new Product object to post to the database. Obtained from the requests' body.
	 * @return ResponseEntity<Product>: The http response entity with the product posted and http status.
	 */
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity;
		Product product = productManager.addProduct(newProduct);
		
		responseEntity = new ResponseEntity<>(product, HttpStatus.CREATED);
		
		return responseEntity;
	}
	
	@PutMapping("/products/{id}")
	/**
	 * Method to update a Product object.
	 * @param Product: the complete replacement to be posted. Obtained from the requests' body.
	 * @param long: the ID of the product to be replaced. Obtained from the queried path.
	 * @return ResponseEntity<Product>: the response entity with the new Product object, and the http status.
	 */
	public ResponseEntity<Product> modifyProduct(@RequestBody Product replacement, @PathVariable(value = "id") long id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	
		productManager.setProduct(id, replacement);
		Optional<Product> replaced = productManager.getProduct(id);

		
		if (replaced.isPresent()) {
			responseEntity = new ResponseEntity<>(replaced.get(), HttpStatus.ACCEPTED);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/products/{id}")
	/**
	 * Method to delete a Product from the database.
	 * @param long: the ID of the Product to be deleted. Obtained from the queried path.
	 * @return ResponseEntity<List<Product>>: the response entity with a list of all found Product, which should not contain the Product with the provided id; and the http status.
	 */
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable(value = "id") long id) {
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.deleteProduct(product.get());
			
			responseEntity = new ResponseEntity<List<Product>>(productManager.getProducts(), HttpStatus.ACCEPTED);
		}
		return responseEntity;
	}
	
	/** * The end point for GET {url}/products?search={pattern} 
	 * * @param search Pattern to search 
	 * * @return a json list of all the products matching the pattern */
	@GetMapping(value="/products", params="search") 
	public ResponseEntity<List<Product>> getProducts(@RequestParam String search) {
		List<Product> products = productManager.getProducts(search);
		return new ResponseEntity<>(products, HttpStatus.OK);
		} 
} 

