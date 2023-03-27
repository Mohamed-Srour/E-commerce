package gov.iti.jets.ecommerce.business.servicesImpl;
import gov.iti.jets.ecommerce.business.dtos.AdminDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminRegisterDTO;
import gov.iti.jets.ecommerce.business.mappers.AdminMapper;
import gov.iti.jets.ecommerce.business.services.AdminService;
import gov.iti.jets.ecommerce.persistence.entities.Admin;
import gov.iti.jets.ecommerce.persistence.repositories.AdminRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdminServiceImpl  implements AdminService {
    private final AdminRepo adminRepo;
    private final AdminMapper adminMapper;


    @Override
    public AdminDTO find(String username, String password) {
        Admin admin = adminRepo.findAdminByUsernameAndPassword(username, password);
        if (admin != null) {

            return adminMapper.adminToAdminDto(admin);
        }
        return null;
    }

    @Override
    public AdminDTO find(Integer id) {

        Optional<Admin> admin = adminRepo.findById(id);
        return admin.map(adminMapper::adminToAdminDto).orElse(null);
    }

    @Override
    public List<AdminDTO> getAll() {
        return adminMapper.adminListToAdminDtoList(adminRepo.findAll());
    }

    @Override
    public AdminDTO add(AdminRegisterDTO adminRegisterDTO) {
        Admin admin = adminRepo.save(adminMapper.adminRegisterDtoToAdmin(adminRegisterDTO));
        return adminMapper.adminToAdminDto(admin);
    }

    @Override
    public void delete(AdminDTO adminDTO) {
        adminRepo.delete(adminMapper.adminDtoToAdmin(adminDTO));
    }

    @Override
    public AdminDTO update(AdminRegisterDTO adminRegisterDTO) {
        Admin oldAdmin = adminRepo.findById(adminRegisterDTO.getId()).orElse(null);
        if (oldAdmin != null) {
            if (adminRegisterDTO.getPassword() == null) {
                adminRegisterDTO.setPassword(oldAdmin.getPassword());
            }
            if (adminRegisterDTO.getUserName() == null) {
                adminRegisterDTO.setUserName(oldAdmin.getUsername());
            }
            if (adminRegisterDTO.getEmail() == null) {
                adminRegisterDTO.setEmail(oldAdmin.getEmail());
            }
            if (adminRegisterDTO.getPhone() == null) {
                adminRegisterDTO.setPhone(oldAdmin.getPhone());
            }
        }

        Admin admin = adminRepo.save(adminMapper.adminRegisterDtoToAdmin(adminRegisterDTO));

        return adminMapper.adminToAdminDto(admin);
    }


}
