package gov.iti.jets.ecommerce.presentation.controllers;

import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.CustomerService;
import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "BearerAuth")
@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    final private CustomerService customerService;

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseDTO getProfile(@PathVariable Integer id){
    return new ResponseDTO(
            "Get Customer Successfully",
            true,
            200,
            customerService.find(id)
    ) ;
    }


    @RolesAllowed("ADMIN")
    @ResponseBody
    @GetMapping("/all")
    public ResponseDTO getAllCustomers(){
        return new ResponseDTO(
                "Get All Customer Successfully",
                true,
                200,
                customerService.getAll()
        ) ;
    }


   @PostMapping
   public ResponseDTO addCustomer(@RequestBody CustomerDTO customerDTO){
       return new ResponseDTO(
               "Add Customer Successfully",
               true,
               200,
               customerService.add(customerDTO)
       ) ;

   }
    @DeleteMapping
    public void delete(@RequestBody CustomerDTO customerDTO){
        customerService.delete(customerDTO);
    }
    @PutMapping
    public ResponseDTO update(@RequestBody CustomerDTO customerDTO){
        return new ResponseDTO(
                "Add Customer Successfully",
                true,
                200,
                customerService.update(customerDTO)
        ) ;
    }
    @RolesAllowed("CUSTOMER")
    @GetMapping("/walet/{id}/{price}")
    public ResponseDTO updateWallet(@PathVariable Integer id , @PathVariable Double price){
        return new ResponseDTO("updated successfully" , true , 200 ,customerService.updateWallet(id,price)) ;
    }
}
