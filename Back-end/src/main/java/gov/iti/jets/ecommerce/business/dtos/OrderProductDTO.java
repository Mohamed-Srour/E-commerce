package gov.iti.jets.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {

    private OrderProductIdDTO id;
    private ProductsOrderDTO product;
    private Integer amount;
}
