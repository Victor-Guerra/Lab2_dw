package mx.tec.lab.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
/**
 * Class for Products
 * @author victorg
 *
 */
public class Product implements Serializable{
	/**
	 *  UID for the class
	 */
	private static final long serialVersionUID = -5834952474454604066L;
	
	@Id
	@GeneratedValue
	/**
	 * Unique Identificator of an instance of a Product
	 */
	private long id;
	/**
	 * Name of the instancce of Product
	 */
	private String name;
	/**
	 * Description of the instanc of Product
	 */
	private String description;
	@OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL)
	/**
	 * List of SKUs of the instance of Product
	 */
	private List<Sku> childSkus;
	
	/**
	 * Empty Constructor for the Product Class
	 */
	public Product() {

	}
	
	/**
	 * Product Class constructor with all the properties
	 * @param id
	 * @param name
	 * @param description
	 * @param childSkus
	 */
	public Product(long id, String name, String description, List<Sku> childSkus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childSkus = childSkus;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the childSkus
	 */
	public List<Sku> getChildSkus() {
		return childSkus;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param childSkus the childSkus to set
	 */
	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	@Override
	/**
	 * Parses the information of a Product Object into a String
	 * @return 
	 **/
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", childSkus=" + childSkus
				+ "]";
	}

	@Override
	/**
	 * Get a hash code according to the ID of the Object
	 * @return hash: a hash code of the Object
	 */
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	/**
	 * Compare the equality between two objects of type Product.
	 * @param obj: the object to compare with the current one.
	 * @returns the result of the equality comparison.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return id == other.id;
	}
}
