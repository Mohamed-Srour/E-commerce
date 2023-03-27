package gov.iti.jets.ecommerce.business.servicesImpl;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.mappers.AddressMapper;
import gov.iti.jets.ecommerce.business.services.AddressService;
import gov.iti.jets.ecommerce.exceptions.ResourceNotFoundException;
import gov.iti.jets.ecommerce.persistence.repositories.AddressRepo;
import gov.iti.jets.ecommerce.persistence.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;


@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;
    private final CustomerRepo customerRepo;
    @Override
    public Set<AddressDTO> getAddresses(Integer id) {
        if(customerRepo.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        }
        return addressMapper.addressSetToAddressDTOSet(addressRepo.findAllByCustomerId(id));
    }
}
