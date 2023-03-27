package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import gov.iti.jets.ecommerce.business.dtos.CustomerResponse;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T09:44:45+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setUsername( customer.getUsername() );
        customerDTO.setRole( customer.getRole() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setId( customer.getId() );
        customerDTO.setIsMale( customer.getIsMale() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setWalletLimit( customer.getWalletLimit() );

        return customerDTO;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setEmail( customerDTO.getEmail() );
        customer.setId( customerDTO.getId() );
        customer.setPhone( customerDTO.getPhone() );
        customer.setRole( customerDTO.getRole() );
        customer.setUsername( customerDTO.getUsername() );
        customer.setIsMale( customerDTO.getIsMale() );
        customer.setWalletLimit( customerDTO.getWalletLimit() );

        return customer;
    }

    @Override
    public List<CustomerDTO> customerListToCustomerDtoList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( customerToCustomerDto( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> customerDtoListToCustomerList(List<CustomerDTO> customerDTOS) {
        if ( customerDTOS == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDTOS.size() );
        for ( CustomerDTO customerDTO : customerDTOS ) {
            list.add( customerDtoToCustomer( customerDTO ) );
        }

        return list;
    }

    @Override
    public CustomerResponse CustomerToCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setWalletLimit( customer.getWalletLimit() );
        customerResponse.setDob( customer.getDob() );
        customerResponse.setEmail( customer.getEmail() );
        customerResponse.setId( customer.getId() );
        customerResponse.setIsMale( customer.getIsMale() );
        customerResponse.setPhone( customer.getPhone() );
        customerResponse.setRole( customer.getRole() );
        customerResponse.setUsername( customer.getUsername() );

        return customerResponse;
    }
}
