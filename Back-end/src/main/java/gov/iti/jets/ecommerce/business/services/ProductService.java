package gov.iti.jets.ecommerce.business.services;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductCategoriesDTO;


public interface ProductService {
   
    public List<ProductCategoriesDTO> getAllProducts();
    List<ProductCategoriesDTO> findALlProducts();
    public Optional<ProductCategoriesDTO> getProduct(Integer id);
    public void addProduct (ProductCategoriesDTO productDTO);
    public void updateProduct (ProductCategoriesDTO productDTO);
    public void deleteProduct (Integer id);
    // public Integer getStockById(Integer id);
    public List<Integer> checkStockProduct(List<OrderProductDTO> productDTO);
	public void updateStockProduct(List<OrderProductDTO> productDTO);
    public Object findALlProductsByTime();


}
