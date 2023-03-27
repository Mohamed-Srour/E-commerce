package gov.iti.jets.ecommerce.persistence.repositories;


import gov.iti.jets.ecommerce.persistence.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findCustomerByUsernameAndPassword(String userName , String password);

    Optional<Customer> findCustomerByUsername(String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Customer c SET c.walletLimit = c.walletLimit - :price WHERE c.id = :id")
    int updateWallet(Integer id, Double price);
}
