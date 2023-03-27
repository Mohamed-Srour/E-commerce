package gov.iti.jets.ecommerce.business.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Set<ProductWithoutCategriesDTO> products ;
    
}
