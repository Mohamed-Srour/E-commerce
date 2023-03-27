package gov.iti.jets.ecommerce.business.dtos;

import java.util.Set;

import gov.iti.jets.ecommerce.persistence.entities.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDTO {

    private Integer id;
    private Set<AddressDTO> addresses;
    private String username;
    private String email;
    private double walletLimit;
    private String phone;
    private Role role;

}
