package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.CategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductCategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductWithoutCategriesDTO;
import gov.iti.jets.ecommerce.persistence.entities.Category;
import gov.iti.jets.ecommerce.persistence.entities.Product;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T09:44:45+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductHasCategoriesMapperImpl implements ProductHasCategoriesMapper {

    @Override
    public List<ProductCategoriesDTO> productToProductDto(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductCategoriesDTO> list = new ArrayList<ProductCategoriesDTO>( product.size() );
        for ( Product product1 : product ) {
            list.add( productToProductDtoId( product1 ) );
        }

        return list;
    }

    @Override
    public ProductCategoriesDTO productToProductDtoId(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductCategoriesDTO productCategoriesDTO = new ProductCategoriesDTO();

        productCategoriesDTO.setCategories( categorySetToCategoriesDTOSet( product.getCategories() ) );
        productCategoriesDTO.setDescription( product.getDescription() );
        productCategoriesDTO.setId( product.getId() );
        productCategoriesDTO.setImagePath( product.getImagePath() );
        productCategoriesDTO.setName( product.getName() );
        productCategoriesDTO.setPrice( product.getPrice() );
        productCategoriesDTO.setRate( product.getRate() );
        productCategoriesDTO.setStock( product.getStock() );

        return productCategoriesDTO;
    }

    @Override
    public Product productDtoToProduct(ProductCategoriesDTO productCategoriesDTO) {
        if ( productCategoriesDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productCategoriesDTO.getId() );
        product.setName( productCategoriesDTO.getName() );
        product.setDescription( productCategoriesDTO.getDescription() );
        product.setPrice( productCategoriesDTO.getPrice() );
        product.setStock( productCategoriesDTO.getStock() );
        product.setImagePath( productCategoriesDTO.getImagePath() );
        product.setRate( productCategoriesDTO.getRate() );
        product.setCategories( categoriesDTOSetToCategorySet( productCategoriesDTO.getCategories() ) );

        return product;
    }

    @Override
    public List<Product> productDtoToProduct(List<ProductCategoriesDTO> product) {
        if ( product == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( product.size() );
        for ( ProductCategoriesDTO productCategoriesDTO : product ) {
            list.add( productDtoToProduct( productCategoriesDTO ) );
        }

        return list;
    }

    @Override
    public ProductWithoutCategriesDTO map(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductWithoutCategriesDTO productWithoutCategriesDTO = new ProductWithoutCategriesDTO();

        productWithoutCategriesDTO.setDescription( product.getDescription() );
        productWithoutCategriesDTO.setId( product.getId() );
        productWithoutCategriesDTO.setImagePath( product.getImagePath() );
        productWithoutCategriesDTO.setName( product.getName() );
        productWithoutCategriesDTO.setPrice( product.getPrice() );
        productWithoutCategriesDTO.setRate( product.getRate() );
        productWithoutCategriesDTO.setStock( product.getStock() );

        return productWithoutCategriesDTO;
    }

    @Override
    public List<ProductWithoutCategriesDTO> productWithoutCategriesToProduct(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductWithoutCategriesDTO> list = new ArrayList<ProductWithoutCategriesDTO>( products.size() );
        for ( Product product : products ) {
            list.add( map( product ) );
        }

        return list;
    }

    protected CategoriesDTO categoryToCategoriesDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoriesDTO categoriesDTO = new CategoriesDTO();

        categoriesDTO.setDescription( category.getDescription() );
        categoriesDTO.setId( category.getId() );
        categoriesDTO.setName( category.getName() );

        return categoriesDTO;
    }

    protected Set<CategoriesDTO> categorySetToCategoriesDTOSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoriesDTO> set1 = new LinkedHashSet<CategoriesDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Category category : set ) {
            set1.add( categoryToCategoriesDTO( category ) );
        }

        return set1;
    }

    protected Category categoriesDTOToCategory(CategoriesDTO categoriesDTO) {
        if ( categoriesDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoriesDTO.getId() );
        category.setName( categoriesDTO.getName() );
        category.setDescription( categoriesDTO.getDescription() );

        return category;
    }

    protected Set<Category> categoriesDTOSetToCategorySet(Set<CategoriesDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Category> set1 = new LinkedHashSet<Category>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoriesDTO categoriesDTO : set ) {
            set1.add( categoriesDTOToCategory( categoriesDTO ) );
        }

        return set1;
    }
}
