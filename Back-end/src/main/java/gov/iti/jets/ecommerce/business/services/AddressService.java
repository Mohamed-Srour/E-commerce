package gov.iti.jets.ecommerce.business.services;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;

import java.util.Set;

public interface AddressService {

    Set<AddressDTO> getAddresses(Integer id);
}
