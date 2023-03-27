package gov.iti.jets.ecommerce.business.dtos;

import java.util.Set;

import gov.iti.jets.ecommerce.persistence.entities.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String username;
    private Boolean isMale;
    private double walletLimit;
    private Role role;
    private String email;
    private String phone;
    
}
