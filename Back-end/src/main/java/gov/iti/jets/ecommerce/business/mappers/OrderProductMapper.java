package gov.iti.jets.ecommerce.business.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.dtos.OrderProductIdDTO;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProduct;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProductId;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {


    // OrderProductIdDTO orderProductIdToOrderProductIdDTO(OrderHasProductId orderHasProductId);

    // OrderHasProductId orderProductIdDTOToOrderProductId(OrderProductIdDTO orderProductId);

    OrderProductDTO orderProductToOrderProductDTO(OrderHasProduct orderHasProduct);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderHasProduct orderProductDTOToOrderProduct(OrderProductDTO orderProductId);

    
}
