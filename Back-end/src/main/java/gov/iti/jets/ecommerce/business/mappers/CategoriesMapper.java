package gov.iti.jets.ecommerce.business.mappers;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.iti.jets.ecommerce.business.dtos.CategoriesDTO;
import gov.iti.jets.ecommerce.business.dtos.CategoriesProductDTO;
import gov.iti.jets.ecommerce.persistence.entities.Category;


@Mapper(componentModel = "spring")
public interface CategoriesMapper {

    List<CategoriesDTO> categoriesToCategoriesDto (List<Category> category);

    // List<Category> categoriesDtoToCategories (List<CategoriesDTO> category);

    CategoriesProductDTO map(Category category);
    List<CategoriesProductDTO> categoriesToCategoriesDTO(List<Category> category);
  
    @Mapping(target = "id", source = "id")
    Category categoryDtoToCategory(CategoriesProductDTO category);
    }

    