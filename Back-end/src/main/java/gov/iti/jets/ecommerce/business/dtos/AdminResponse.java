package gov.iti.jets.ecommerce.business.dtos;

import gov.iti.jets.ecommerce.persistence.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Role role;
    private String token;
}
