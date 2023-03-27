package gov.iti.jets.ecommerce.business.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Integer id;
    private String area;
    private Integer buildingNum;
    private Integer floorNum;
    private String street;
    private CustomerDTO customer;    
}
