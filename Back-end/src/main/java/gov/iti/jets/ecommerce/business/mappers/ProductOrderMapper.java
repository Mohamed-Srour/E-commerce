package gov.iti.jets.ecommerce.business.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper
public interface ProductOrderMapper {
    
    ProductOrderMapper mapper = Mappers.getMapper(ProductOrderMapper.class);

    // Set<ProductsOrderDTO> ordersProductToOrderProductDTO (Set<OrderHasProduct> product);
   
    // Set<OrderHasProduct> orderProductDTOToOrdersProduct (Set<ProductsOrderDTO> productDTO);
}
