package gov.iti.jets.ecommerce.business.dtos;

import java.util.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

    private Integer id;
    private Double totalPrice;
    private Boolean isSubmitted;
    private String paymentType;
    private Date submitDate;
    private AddressDTO addressDTO;
    private CustomerOrderDTO customerOrderDTO;
    private Set<OrderHasProductDTO> orderHasProductsDTO = new HashSet<OrderHasProductDTO>(0);
    
}
