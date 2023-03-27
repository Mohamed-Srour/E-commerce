package gov.iti.jets.ecommerce.business.mappers;
import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import gov.iti.jets.ecommerce.business.dtos.CustomerResponse;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "username" , source = "username")
    @Mapping(target = "role",source = "role")
    CustomerDTO customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> customerListToCustomerDtoList (List<Customer> customers);
    List<Customer> customerDtoListToCustomerList(List<CustomerDTO> customerDTOS);

    @Mapping(target= "walletLimit", source = "walletLimit")
    CustomerResponse CustomerToCustomerResponse(Customer customer);
}
