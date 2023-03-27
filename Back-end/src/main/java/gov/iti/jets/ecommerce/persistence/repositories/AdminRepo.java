package gov.iti.jets.ecommerce.persistence.repositories;

import gov.iti.jets.ecommerce.persistence.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findAdminByUsernameAndPassword(String userName , String password);

    Optional<Admin> findAdminByUsername(String userName);
}
