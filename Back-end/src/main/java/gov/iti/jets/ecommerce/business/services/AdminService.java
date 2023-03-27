package gov.iti.jets.ecommerce.business.services;

import gov.iti.jets.ecommerce.business.dtos.AdminDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminRegisterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
     AdminDTO find(String username, String password);
     AdminDTO find(Integer id);
     List<AdminDTO> getAll();
     AdminDTO add(AdminRegisterDTO adminRegisterDTO);
     void delete(AdminDTO adminDTO);
     AdminDTO update(AdminRegisterDTO adminRegisterDTO);

}
