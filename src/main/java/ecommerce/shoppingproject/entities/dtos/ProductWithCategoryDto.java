package ecommerce.shoppingproject.entities.dtos;

public class ProductWithCategoryDto {
	public ProductWithCategoryDto(){}
	private int id;
	private String productName;
	private String categoryName;
	private String productDetail;
	private double unitPrice;
	private String productBrandname;
	private String productShortname;
	private String productImage;
	public ProductWithCategoryDto(int id, String productName, String categoryName, String productDetail,
			double unitPrice, String productBrandname, String productShortname, String productImage) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.productDetail = productDetail;
		this.unitPrice = unitPrice;
		this.productBrandname = productBrandname;
		this.productShortname = productShortname;
		this.productImage = productImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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
	
}
