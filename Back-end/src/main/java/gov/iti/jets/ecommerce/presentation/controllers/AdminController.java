package gov.iti.jets.ecommerce.presentation.controllers;

import gov.iti.jets.ecommerce.business.dtos.AdminDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminRegisterDTO;
import gov.iti.jets.ecommerce.business.services.AdminService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SecurityRequirement(name = "BearerAuth")
@RolesAllowed("ADMIN")
@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;



    @GetMapping("/{id}")
    @ResponseBody
    public AdminDTO get(@PathVariable Integer id){
        return  adminService.find(id);
    }

//    @RolesAllowed("ADMIN")
    @GetMapping("/all")
    @ResponseBody
    public List<AdminDTO> getAll(){
        return  adminService.getAll();
    }


    @PostMapping
    @ResponseBody
    public  AdminDTO add(@RequestBody AdminRegisterDTO adminRegisterDTO){
        return  adminService.add(adminRegisterDTO);
    }

    @DeleteMapping
    public  void  delete(@RequestBody  AdminDTO adminDTO){
        adminService.delete(adminDTO);
    }

    @PatchMapping
    public  AdminDTO update(@RequestBody  AdminRegisterDTO adminRegisterDTO){
        return adminService.update(adminRegisterDTO);
    }


    
}
