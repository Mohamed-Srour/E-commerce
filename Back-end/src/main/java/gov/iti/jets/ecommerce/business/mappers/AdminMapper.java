package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.AdminDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminRegisterDTO;
import gov.iti.jets.ecommerce.business.dtos.AdminResponse;
import gov.iti.jets.ecommerce.persistence.entities.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mapping(target = "username" , source = "username")
    AdminDTO adminToAdminDto(Admin admin);

    Admin adminDtoToAdmin(AdminDTO adminDTO);

    @Mapping(target = "id",source = "id")
    Admin adminRegisterDtoToAdmin(AdminRegisterDTO adminRegisterDTO);

    List<AdminDTO> adminListToAdminDtoList(List<Admin> adminList);

    AdminResponse adminTOAdminResponse(Admin admin);
}
