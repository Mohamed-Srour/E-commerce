package gov.iti.jets.ecommerce.business.dtos;

// import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoriesDTO {
   
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imagePath;
    private Double rate;
    private Set<CategoriesDTO> categories;
    
}
