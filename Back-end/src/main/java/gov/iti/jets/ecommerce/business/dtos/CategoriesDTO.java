package gov.iti.jets.ecommerce.business.dtos;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {
    
    private Integer id;
    private String name;
    private String description;

}

