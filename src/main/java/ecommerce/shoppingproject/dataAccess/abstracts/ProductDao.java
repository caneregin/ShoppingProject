package ecommerce.shoppingproject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.shoppingproject.entities.concretes.Product;
import ecommerce.shoppingproject.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> {
	Product getByProductName(String productName);
	
	Product getByProductId(Integer productId);
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	@Query("Select new ecommerce.shoppingproject.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName, p.productDetail, p.unitPrice) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	@Query("Select new ecommerce.shoppingproject.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName, p.productDetail, p.unitPrice) From Category c Inner Join c.products p where c.categoryName=:categoryName")
	List<ProductWithCategoryDto> getProductWithCategoryDetailsAccordingToCategoryName(String categoryName);

}
