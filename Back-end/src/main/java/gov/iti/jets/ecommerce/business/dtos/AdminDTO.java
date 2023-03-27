package gov.iti.jets.ecommerce.business.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Integer id;
    private String username;
    private String email;
    private String phone;

}
