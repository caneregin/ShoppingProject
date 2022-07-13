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
	
	@Column(name="product_detail1")
	private String productDetail1;
	
	@Column(name="product_detail2")
	private String productDetail2;
	
	@Column(name="product_detail3")
	private String productDetail3;
	
	@Column(name="product_detail4")
	private String productDetail4;
	
	@Column(name="product_detail5")
	private String productDetail5;
	
	@Column(name="product_detail6")
	private String productDetail6;
	
	@Column(name="product_brandname")
	private String productBrandname;
	
	@Column(name="product_shortname")
	private String productShortname;
	
	@Column(name="product_image")
	private String productImage;
	
	@Column(name="product_imagedetail1")
	private String productImageDetail1;
	
	@Column(name="product_imagedetail2")
	private String productImageDetail2;
	
	@Column(name="product_imagedetail3")
	private String productImageDetail3;
	
	@Column(name="product_imagedetail4")
	private String productImageDetail4;
	
	@Column(name="product_imagedetail5")
	private String productImageDetail5;
	
	@Column(name="product_imagedetail6")
	private String productImageDetail6;
	
	@Column(name="unit_price")
	private double unitPrice;	
	
	@Column(name="units_in_stock")
	private double unitsInStock;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	public Product() {}

	public Product(int productId, String productName, String productDetail, String productDetail1,
			String productDetail2, String productDetail3, String productDetail4, String productDetail5,
			String productDetail6, String productBrandname, String productShortname, String productImage,
			String productImageDetail1, String productImageDetail2, String productImageDetail3,
			String productImageDetail4, String productImageDetail5, String productImageDetail6, double unitPrice,
			double unitsInStock, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productDetail1 = productDetail1;
		this.productDetail2 = productDetail2;
		this.productDetail3 = productDetail3;
		this.productDetail4 = productDetail4;
		this.productDetail5 = productDetail5;
		this.productDetail6 = productDetail6;
		this.productBrandname = productBrandname;
		this.productShortname = productShortname;
		this.productImage = productImage;
		this.productImageDetail1 = productImageDetail1;
		this.productImageDetail2 = productImageDetail2;
		this.productImageDetail3 = productImageDetail3;
		this.productImageDetail4 = productImageDetail4;
		this.productImageDetail5 = productImageDetail5;
		this.productImageDetail6 = productImageDetail6;
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

	public String getProductDetail1() {
		return productDetail1;
	}

	public void setProductDetail1(String productDetail1) {
		this.productDetail1 = productDetail1;
	}

	public String getProductDetail2() {
		return productDetail2;
	}

	public void setProductDetail2(String productDetail2) {
		this.productDetail2 = productDetail2;
	}

	public String getProductDetail3() {
		return productDetail3;
	}

	public void setProductDetail3(String productDetail3) {
		this.productDetail3 = productDetail3;
	}

	public String getProductDetail4() {
		return productDetail4;
	}

	public void setProductDetail4(String productDetail4) {
		this.productDetail4 = productDetail4;
	}

	public String getProductDetail5() {
		return productDetail5;
	}

	public void setProductDetail5(String productDetail5) {
		this.productDetail5 = productDetail5;
	}

	public String getProductDetail6() {
		return productDetail6;
	}

	public void setProductDetail6(String productDetail6) {
		this.productDetail6 = productDetail6;
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

	public String getProductImageDetail1() {
		return productImageDetail1;
	}

	public void setProductImageDetail1(String productImageDetail1) {
		this.productImageDetail1 = productImageDetail1;
	}

	public String getProductImageDetail2() {
		return productImageDetail2;
	}

	public void setProductImageDetail2(String productImageDetail2) {
		this.productImageDetail2 = productImageDetail2;
	}

	public String getProductImageDetail3() {
		return productImageDetail3;
	}

	public void setProductImageDetail3(String productImageDetail3) {
		this.productImageDetail3 = productImageDetail3;
	}

	public String getProductImageDetail4() {
		return productImageDetail4;
	}

	public void setProductImageDetail4(String productImageDetail4) {
		this.productImageDetail4 = productImageDetail4;
	}

	public String getProductImageDetail5() {
		return productImageDetail5;
	}

	public void setProductImageDetail5(String productImageDetail5) {
		this.productImageDetail5 = productImageDetail5;
	}

	public String getProductImageDetail6() {
		return productImageDetail6;
	}

	public void setProductImageDetail6(String productImageDetail6) {
		this.productImageDetail6 = productImageDetail6;
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
