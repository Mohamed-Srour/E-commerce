package gov.iti.jets.ecommerce.presentation.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.OrdersService;

@SecurityRequirement(name = "BearerAuth")
@RestController
@RequestMapping("/cart")
public class CartController {

    private final OrdersService ordersService;

    public CartController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


//    with customer id
    @RolesAllowed("CUSTOMER")
    @GetMapping("/{id}")
    public ResponseDTO getCart(@PathVariable Integer id) {
        return  new ResponseDTO("succ", true, 200, ordersService.getCart(id));
    }
}
