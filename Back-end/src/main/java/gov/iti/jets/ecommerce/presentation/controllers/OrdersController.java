package gov.iti.jets.ecommerce.presentation.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.OrdersDTO;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.OrdersService;


@SecurityRequirement(name = "BearerAuth")
@RestController
@RequestMapping("/order")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/orders")
    public ResponseDTO getAllOrders() {
        return new ResponseDTO("ddf", true, 200, ordersService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseDTO getOrderById(@PathVariable Integer id) {

        return new ResponseDTO("order", true, 200, ordersService.getOrderById(id));
    }


//history
    @GetMapping("/customer/{id}")
    public ResponseDTO getCustomerOrderById(@PathVariable Integer id) {
            return new ResponseDTO("customer order",true,200 ,ordersService.getCustomerOrders(id));
    }

    @PostMapping
    public ResponseDTO addOrder(@RequestBody OrdersDTO ordersDTO) {
        return new ResponseDTO("msm", true, 200, ordersService.addOrder(ordersDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.removeOrder(id);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrdersDTO ordersDTO) {
        ordersService.updateOrder(ordersDTO);
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody AddressDTO addressDTO){
        ordersService.addAddress(addressDTO);
    }

    @GetMapping("/address/{id}")
    public ResponseDTO addAddress(@PathVariable Integer id){
        return new ResponseDTO("Address Customer" , true, 200, ordersService.getAddressForCustomer(id));
    }


}
