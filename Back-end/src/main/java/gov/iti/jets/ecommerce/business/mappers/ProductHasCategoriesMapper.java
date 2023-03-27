package gov.iti.jets.ecommerce.business.mappers;
import java.util.List;
import org.mapstruct.Mapper;
import gov.iti.jets.ecommerce.business.dtos.ProductCategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductWithoutCategriesDTO;
import gov.iti.jets.ecommerce.persistence.entities.Product;


@Mapper(componentModel="spring")
public interface ProductHasCategoriesMapper {

 List<ProductCategoriesDTO> productToProductDto (List<Product> product);

 ProductCategoriesDTO productToProductDtoId ( Product product);

 Product productDtoToProduct ( ProductCategoriesDTO productCategoriesDTO);

 List<Product> productDtoToProduct (List<ProductCategoriesDTO> product);

 ProductWithoutCategriesDTO map(Product product);
 List<ProductWithoutCategriesDTO> productWithoutCategriesToProduct(List<Product> products);

}
