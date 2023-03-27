package gov.iti.jets.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;
    private String email;
    private String password;
    private String phone;
    private Boolean isMale;

}
