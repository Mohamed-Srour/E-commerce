package gov.iti.jets.ecommerce.persistence.repositories;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gov.iti.jets.ecommerce.persistence.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

    @Query(value = "select * from address where customer_id = ? ", nativeQuery = true)
    public List<Address> getAddressFprCustomer(Integer id);

    Set<Address> findAllByCustomerId(Integer id);

}
