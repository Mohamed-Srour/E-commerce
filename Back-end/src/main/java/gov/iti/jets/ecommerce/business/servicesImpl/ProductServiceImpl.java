package gov.iti.jets.ecommerce.business.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.iti.jets.ecommerce.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductCategoriesDTO;
import gov.iti.jets.ecommerce.business.mappers.ProductHasCategoriesMapper;
import gov.iti.jets.ecommerce.business.services.ProductService;
import gov.iti.jets.ecommerce.persistence.entities.Product;
import gov.iti.jets.ecommerce.persistence.repositories.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductHasCategoriesMapper productMapper;

    public ProductServiceImpl(ProductRepo productRepo, ProductHasCategoriesMapper productMapper ) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    
    }

    public List<ProductCategoriesDTO> getAllProducts() {

        return productMapper.productToProductDto(productRepo.findAll());

    }

    @Override
    public List<ProductCategoriesDTO> findALlProducts() {
        return productMapper.productToProductDto(productRepo.findAllProducts());
    }

    public Optional<ProductCategoriesDTO> getProduct(Integer id) {

        Optional<Product> product = productRepo.findById(id);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }

        return (product.map(productMapper::productToProductDtoId));

    }

    public void addProduct(ProductCategoriesDTO productDTO) {

        productRepo.save(productMapper.productDtoToProduct(productDTO));
    }

    public void updateProduct(ProductCategoriesDTO productDTO) {

        productRepo.save(productMapper.productDtoToProduct(productDTO));

    }

    public void deleteProduct(Integer id) {

        productRepo.deleteProductById(id);
    }

    @Override
    public List<Integer> checkStockProduct(List<OrderProductDTO> productDTO) {
        
        List<Integer> outOfStock = new ArrayList<>();
        productDTO.forEach((product) -> {
            Integer res = this.productRepo.checkStockProduct(product.getProduct().getId(), product.getAmount());
            if(res > 0){
                outOfStock.add(product.getProduct().getId());
            }
        });
        return outOfStock;
    }

    @Override
    public void updateStockProduct(List<OrderProductDTO> productDTO) {
        productDTO.forEach((product) ->{
            this.productRepo.updateStock(product.getAmount(), product.getProduct().getId());
        });
    }

    @Override
    public List<ProductCategoriesDTO> findALlProductsByTime() {
        return productMapper.productToProductDto(productRepo.findAllProductsByTime());

    }
}
