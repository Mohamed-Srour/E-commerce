package gov.iti.jets.ecommerce.presentation.controllers;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
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

import gov.iti.jets.ecommerce.business.dtos.CategoriesProductDTO;
import gov.iti.jets.ecommerce.business.dtos.ResponseDTO;
import gov.iti.jets.ecommerce.business.services.CategoriesService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CatergoryController {
    final private CategoriesService categoriesService;


    // get all categories
    @GetMapping
    public ResponseDTO getAll() {
       
        return new ResponseDTO("All categories", true, 200,  categoriesService.getAll());
       

    }

    // get category by id
    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable int id) {

        // return categoriesService.getById(id);
        return new ResponseDTO("categories by id", true, 200, categoriesService.getById(id));

    }

    @SecurityRequirement(name = "BearerAuth")
    @RolesAllowed("ADMIN")
    @PostMapping
    public void addCategory(@RequestBody CategoriesProductDTO category) {

        categoriesService.addCategory(category);

    }

    @SecurityRequirement(name = "BearerAuth")
    @RolesAllowed("ADMIN")
    @PutMapping()
    public void updateCategory(@RequestBody CategoriesProductDTO category) {

        categoriesService.addCategory(category);

    }

    @SecurityRequirement(name = "BearerAuth")
    @RolesAllowed("ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id) {
        try {
            categoriesService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SecurityRequirement(name = "BearerAuth")
    @RolesAllowed("ADMIN")
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllCategory() {

        try {
            categoriesService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
