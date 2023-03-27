package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.CategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.CategoriesProductDTO;
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
public class CategoriesMapperImpl implements CategoriesMapper {

    @Override
    public List<CategoriesDTO> categoriesToCategoriesDto(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoriesDTO> list = new ArrayList<CategoriesDTO>( category.size() );
        for ( Category category1 : category ) {
            list.add( categoryToCategoriesDTO( category1 ) );
        }

        return list;
    }

    @Override
    public CategoriesProductDTO map(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoriesProductDTO categoriesProductDTO = new CategoriesProductDTO();

        categoriesProductDTO.setDescription( category.getDescription() );
        categoriesProductDTO.setId( category.getId() );
        categoriesProductDTO.setName( category.getName() );
        categoriesProductDTO.setProducts( productSetToProductWithoutCategriesDTOSet( category.getProducts() ) );

        return categoriesProductDTO;
    }

    @Override
    public List<CategoriesProductDTO> categoriesToCategoriesDTO(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoriesProductDTO> list = new ArrayList<CategoriesProductDTO>( category.size() );
        for ( Category category1 : category ) {
            list.add( map( category1 ) );
        }

        return list;
    }

    @Override
    public Category categoryDtoToCategory(CategoriesProductDTO category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        category1.setId( category.getId() );
        category1.setName( category.getName() );
        category1.setDescription( category.getDescription() );
        category1.setProducts( productWithoutCategriesDTOSetToProductSet( category.getProducts() ) );

        return category1;
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

    protected ProductWithoutCategriesDTO productToProductWithoutCategriesDTO(Product product) {
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

    protected Set<ProductWithoutCategriesDTO> productSetToProductWithoutCategriesDTOSet(Set<Product> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductWithoutCategriesDTO> set1 = new LinkedHashSet<ProductWithoutCategriesDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Product product : set ) {
            set1.add( productToProductWithoutCategriesDTO( product ) );
        }

        return set1;
    }

    protected Product productWithoutCategriesDTOToProduct(ProductWithoutCategriesDTO productWithoutCategriesDTO) {
        if ( productWithoutCategriesDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productWithoutCategriesDTO.getId() );
        product.setName( productWithoutCategriesDTO.getName() );
        product.setDescription( productWithoutCategriesDTO.getDescription() );
        product.setPrice( productWithoutCategriesDTO.getPrice() );
        product.setStock( productWithoutCategriesDTO.getStock() );
        product.setImagePath( productWithoutCategriesDTO.getImagePath() );
        product.setRate( productWithoutCategriesDTO.getRate() );

        return product;
    }

    protected Set<Product> productWithoutCategriesDTOSetToProductSet(Set<ProductWithoutCategriesDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Product> set1 = new LinkedHashSet<Product>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductWithoutCategriesDTO productWithoutCategriesDTO : set ) {
            set1.add( productWithoutCategriesDTOToProduct( productWithoutCategriesDTO ) );
        }

        return set1;
    }
}
