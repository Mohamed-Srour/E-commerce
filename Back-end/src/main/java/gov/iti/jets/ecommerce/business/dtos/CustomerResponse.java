package gov.iti.jets.ecommerce.business.dtos;

import gov.iti.jets.ecommerce.persistence.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Boolean isMale;
    private Date dob;
    private Role role;
    private double walletLimit;
    private String token;
}
