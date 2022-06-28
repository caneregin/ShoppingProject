package ecommerce.shoppingproject.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_detail")
	private String productDetail;
	
	@Column(name="product_brandname")
	private String productBrandname;
	
	@Column(name="product_shortname")
	private String productShortname;
	
	@Column(name="product_image")
	private String productImage;
	
	@Column(name="unit_price")
	private double unitPrice;	
	
	@Column(name="units_in_stock")
	private double unitsInStock;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	public Product() {}

	public Product(int productId, String productName, String productDetail, String productBrandname,
			String productShortname, String productImage, double unitPrice, double unitsInStock, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productBrandname = productBrandname;
		this.productShortname = productShortname;
		this.productImage = productImage;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getProductBrandname() {
		return productBrandname;
	}

	public void setProductBrandname(String productBrandname) {
		this.productBrandname = productBrandname;
	}

	public String getProductShortname() {
		return productShortname;
	}

	public void setProductShortname(String productShortname) {
		this.productShortname = productShortname;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(double unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
