package mx.tec.lab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/***
 * Class of Skus
 * @author victorg
 *
 */
public class Sku implements Serializable {
	
	private static final long serialVersionUID = -2875657531015194756L;
	/**
	 * Serial Version UID
	 */

	@Id
	@GeneratedValue
	/**
	 * Unique Identificator for the instance of Sku
	 */
	private long id;
	/**
	 * parameColor
	 */
	private String color;
	/**
	 * Size
	 */
	private String size;
	/**
	 * Listing Price
	 */
	private double listPrice; 
	/**
	 * Sale Price
	 */
	private double salePrice;
	/**
	 * Quantity Available
	 */
	private double quantityOnHand;
	/** 
	 * Link for a small image of the Product
	 */
	private String smallImgLink;
	/**
	 * Link for a medium image of the Product
	 */
	private String mediumImgLink;
	/**
	 * Link for a large image of the Product
	 */
	private String largeImgLink;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	/**
	 * Access to the Product instance from which this instance of Sku is related
	 */
	private Product parentProduct;
	
	/**
	 * Sku Entity to Store the SKU attributes
	 */
	public Sku() {
		
	}
	/**
	 * Constructor that includes all properties
	 * @param id
	 * @param color
	 * @param size
	 * @param listPrice
	 * @param salePrice
	 * @param quantityOnHand
	 * @param smallImgLink
	 */
	public Sku(long id, String color, String size, double listPrice, double salePrice, double quantityOnHand, String smallImgLink, String mediumImgLink, String largeImgLink) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.quantityOnHand = quantityOnHand;
		this.smallImgLink = smallImgLink;
		this.mediumImgLink = mediumImgLink;
		this.largeImgLink = largeImgLink;
	}
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @return the listPrice
	 */
	public double getListPrice() {
		return listPrice;
	}
	/**
	 * @return the salePrice
	 */
	public double getSalePrice() {
		return salePrice;
	}
	/**
	 * @return the quantityOnHand
	 */
	public double getQuantityOnHand() {
		return quantityOnHand;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @param quantityOnHand the quantityOnHand to set
	 */
	public void setQuantityOnHand(double quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	/**
	 * @return the smallImgLink
	 */
	public String getSmallImgLink() {
		return smallImgLink;
	}
	/**
	 * @param smallImgLink the smallImgLink to set
	 */
	public void setSmallImgLink(String smallImgLink) {
		this.smallImgLink = smallImgLink;
	}
	/**
	 * @return the mediumImgLink
	 */
	public String getMediumImgLink() {
		return mediumImgLink;
	}
	/**
	 * @param mediumImgLink the mediumImgLink to set
	 */
	public void setMediumImgLink(String mediumImgLink) {
		this.mediumImgLink = mediumImgLink;
	}
	/**
	 * @return the largeImgLink
	 */
	public String getLargeImgLink() {
		return largeImgLink;
	}
	/**
	 * @param largeImgLink the largeImgLink to set
	 */
	public void setLargeImgLink(String largeImgLink) {
		this.largeImgLink = largeImgLink;
	}
	/**
	 * @return the parentProduct
	 */
	public Product getParentProduct() {
		return parentProduct;
	}
	/**
	 * @param parentProduct the parentProduct to set
	 */
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}
	@Override
	/**
	 *  Transforms the information in a Sku Object into a String
	 *  @return string with the Sku Object information
	 */
	public String toString() {
		return "Sku [id=" + id + ", color=" + color + ", size=" + size + ", listPrice=" + listPrice + ", salePrice="
				+ salePrice + ", quantityOnHand=" + quantityOnHand + ", smallImgLink=" + smallImgLink
				+ ", mediumImgLink=" + mediumImgLink + ", largeImgLink=" + largeImgLink + ", parentProduct="
				+ parentProduct + "]";
	}
	@Override
	/**
	 * to Get a Hash code according to the Objects' Id
	 * @return hash: a hash code for the Object
	 */
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	/**
	 * Compare Equality between Sku Objects based on the Id
	 * @param obj: the object to comare with the current one
	 * @return the equality evaluation of the two objects
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sku)) {
			return false;
		}
		Sku other = (Sku) obj;
		return id == other.id;
	}
	
}
