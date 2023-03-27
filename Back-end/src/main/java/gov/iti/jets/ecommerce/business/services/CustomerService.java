package gov.iti.jets.ecommerce.business.services;

import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
     List<CustomerDTO> getAll();
     CustomerDTO find(Integer id);
     CustomerDTO find(String userName , String password);
     CustomerDTO add(CustomerDTO customerDTO);
     boolean delete(Integer customerId);
     boolean delete(CustomerDTO customerDTO);
     CustomerDTO update(CustomerDTO customerDTO);

    int updateWallet(Integer id, Double price);
}
