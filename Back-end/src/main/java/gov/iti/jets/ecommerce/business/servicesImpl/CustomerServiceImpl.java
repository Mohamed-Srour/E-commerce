package gov.iti.jets.ecommerce.business.servicesImpl;

import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import gov.iti.jets.ecommerce.business.mappers.CustomerMapper;
import gov.iti.jets.ecommerce.business.services.CustomerService;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import gov.iti.jets.ecommerce.persistence.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private  final CustomerMapper customerMapper;
    private  final CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getAll(){
        return  customerMapper.customerListToCustomerDtoList(customerRepo.findAll());
    }

    @Override
    public CustomerDTO find(Integer id) {
        Optional<Customer> customer = customerRepo.findById(id);

        return customer.map(customerMapper::customerToCustomerDto).orElse(null);

    }

    @Override
    public CustomerDTO find(String userName, String password) {
        Customer customer =  customerRepo.findCustomerByUsernameAndPassword(userName , password);
        if (customer != null){

            return  customerMapper.customerToCustomerDto(customer);
        }
        return null;

    }

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        Customer customer = customerRepo.save(customerMapper.customerDtoToCustomer(customerDTO)) ;
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public boolean delete(Integer customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if(customer != null){
            customerRepo.delete(customer);
            return true;
        }
        //Customer with customer Id not found
        return false;
    }

    @Override
    public boolean delete(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        if(customer != null){
            customerRepo.delete(customer);
            return  true;
        }
        //Customer Not Found
        return false;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer =customerRepo.save(customerMapper.customerDtoToCustomer(customerDTO));
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public int updateWallet(Integer id, Double price) {
        return customerRepo.updateWallet(id , price);
    }

}
