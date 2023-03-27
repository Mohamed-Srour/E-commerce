package gov.iti.jets.ecommerce.persistence.repositories;

import gov.iti.jets.ecommerce.persistence.entities.Admin;
import gov.iti.jets.ecommerce.persistence.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Integer> {

    Optional<User> findUserByUsername(String userName);
    Optional<User> findUserByEmail(String email);
  
}
