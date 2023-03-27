package gov.iti.jets.ecommerce.presentation.controllers;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.AddressService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SecurityRequirement(name = "BearerAuth")
@RolesAllowed({"ADMIN","CUSTOMER"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseDTO getCustomerAddresses(@PathVariable Integer id){
       return new ResponseDTO("get all address successfully",
               true,
               200,
               addressService.getAddresses(id));
    }

}
