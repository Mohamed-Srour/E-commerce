package gov.iti.jets.ecommerce.presentation.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.ProductOrderService;


@SecurityRequirement(name = "BearerAuth")
@RestController
@RequestMapping("/productOrder")
public class ProductOrdersController {

    private final ProductOrderService productOrderService;

    public ProductOrdersController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/{productId}/{orderId}")
    public ResponseDTO chickProductAddedToCart(@PathVariable Integer productId, @PathVariable Integer orderId) {
        return new ResponseDTO("succsess", true, 200, this.productOrderService.chickProductAddedToCart(productId, orderId));
    }

    @PostMapping
    public ResponseDTO addProductToCustomerOrder(@RequestBody OrderProductDTO orderProductDTO) {
        this.productOrderService.addProductOrder(orderProductDTO);
        return new ResponseDTO("succsess", true, 200);
    }

    @DeleteMapping("/{productId}/{orderId}")
    public ResponseDTO deleteProductFromCart(@PathVariable Integer productId, @PathVariable Integer orderId) {
        this.productOrderService.deleteProductFromCart(productId, orderId);
        return new ResponseDTO("succsess", true, 200);
    }
}
