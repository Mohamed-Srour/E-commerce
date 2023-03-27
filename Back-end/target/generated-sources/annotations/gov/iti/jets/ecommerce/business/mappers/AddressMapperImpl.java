package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import gov.iti.jets.ecommerce.persistence.entities.Address;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T09:44:45+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDTO AddressEntityToDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setArea( address.getArea() );
        addressDTO.setBuildingNum( address.getBuildingNum() );
        addressDTO.setCustomer( customerToCustomerDTO( address.getCustomer() ) );
        addressDTO.setFloorNum( address.getFloorNum() );
        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );

        return addressDTO;
    }

    @Override
    public Address AddresDTOtoEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setCustomer( customerDTOToCustomer( addressDTO.getCustomer() ) );
        address.setArea( addressDTO.getArea() );
        address.setBuildingNum( addressDTO.getBuildingNum() );
        address.setFloorNum( addressDTO.getFloorNum() );
        address.setStreet( addressDTO.getStreet() );

        return address;
    }

    @Override
    public Set<AddressDTO> addressSetToAddressDTOSet(Set<Address> addressSet) {
        if ( addressSet == null ) {
            return null;
        }

        Set<AddressDTO> set = new LinkedHashSet<AddressDTO>( Math.max( (int) ( addressSet.size() / .75f ) + 1, 16 ) );
        for ( Address address : addressSet ) {
            set.add( AddressEntityToDTO( address ) );
        }

        return set;
    }

    protected CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setId( customer.getId() );
        customerDTO.setIsMale( customer.getIsMale() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setRole( customer.getRole() );
        customerDTO.setUsername( customer.getUsername() );
        customerDTO.setWalletLimit( customer.getWalletLimit() );

        return customerDTO;
    }

    protected Customer customerDTOToCustomer(CustomerDTO customerDTO) {
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
}
