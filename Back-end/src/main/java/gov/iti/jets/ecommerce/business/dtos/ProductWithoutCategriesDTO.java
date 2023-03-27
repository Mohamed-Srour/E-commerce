package gov.iti.jets.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithoutCategriesDTO {
    private Integer id;
     private String name;
     private String description;
     private Double price = 0.0;
     private Integer stock = 0;
     private String imagePath;
     private Double rate = 0.0;
     
}
