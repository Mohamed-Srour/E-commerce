package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.AdminDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminRegisterDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminResponse;
import gov.iti.jets.ecommerce.persistence.entities.Admin;
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
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDTO adminToAdminDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setUsername( admin.getUsername() );
        adminDTO.setEmail( admin.getEmail() );
        adminDTO.setId( admin.getId() );
        adminDTO.setPhone( admin.getPhone() );

        return adminDTO;
    }

    @Override
    public Admin adminDtoToAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setEmail( adminDTO.getEmail() );
        admin.setId( adminDTO.getId() );
        admin.setPhone( adminDTO.getPhone() );
        admin.setUsername( adminDTO.getUsername() );

        return admin;
    }

    @Override
    public Admin adminRegisterDtoToAdmin(AdminRegisterDTO adminRegisterDTO) {
        if ( adminRegisterDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setId( adminRegisterDTO.getId() );
        admin.setEmail( adminRegisterDTO.getEmail() );
        admin.setPassword( adminRegisterDTO.getPassword() );
        admin.setPhone( adminRegisterDTO.getPhone() );

        return admin;
    }

    @Override
    public List<AdminDTO> adminListToAdminDtoList(List<Admin> adminList) {
        if ( adminList == null ) {
            return null;
        }

        List<AdminDTO> list = new ArrayList<AdminDTO>( adminList.size() );
        for ( Admin admin : adminList ) {
            list.add( adminToAdminDto( admin ) );
        }

        return list;
    }

    @Override
    public AdminResponse adminTOAdminResponse(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminResponse adminResponse = new AdminResponse();

        adminResponse.setEmail( admin.getEmail() );
        adminResponse.setId( admin.getId() );
        adminResponse.setPhone( admin.getPhone() );
        adminResponse.setRole( admin.getRole() );
        adminResponse.setUsername( admin.getUsername() );

        return adminResponse;
    }
}
