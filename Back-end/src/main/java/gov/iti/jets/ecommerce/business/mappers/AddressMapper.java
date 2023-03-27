package gov.iti.jets.ecommerce.business.mappers;

import org.mapstruct.Mapper;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.persistence.entities.Address;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    


    AddressDTO AddressEntityToDTO(Address address);

    Address AddresDTOtoEntity(AddressDTO addressDTO);

    Set<AddressDTO> addressSetToAddressDTOSet(Set<Address> addressSet);

    // public AddressDTO addresstoDTO(Address address) {
    //     AddressDTO addressDTO = new AddressDTO();
    //     addressDTO.setArea(address.getArea());
    //     addressDTO.setBuildingNum(address.getBuildingNum());
    //     addressDTO.setFloorNum(address.getFloorNum());
    //     addressDTO.setId(address.getId());
    //     addressDTO.setStreet(address.getStreet());
    //     return addressDTO ;
    // }

    // public Address AdressDTOtoAddress(AddressDTO addressDTO){
    //     Address address = new Address();
    //     address.setArea(addressDTO.getArea());
    //     address.setBuildingNum(addressDTO.getBuildingNum());
    //     address.setFloorNum(addressDTO.getFloorNum());
    //     address.setId(addressDTO.getId());
    //     address.setStreet(addressDTO.getStreet());
    //     return address;
    // }
    
}
