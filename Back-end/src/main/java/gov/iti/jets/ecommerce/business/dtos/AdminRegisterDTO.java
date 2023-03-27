package gov.iti.jets.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterDTO {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private String phone;
}
