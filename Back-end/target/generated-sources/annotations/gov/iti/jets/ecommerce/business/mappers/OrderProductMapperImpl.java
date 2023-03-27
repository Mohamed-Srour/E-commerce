package gov.iti.jets.ecommerce.business.mappers;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.dtos.OrderProductIdDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductsOrderDTO;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProduct;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProductId;
import gov.iti.jets.ecommerce.persistence.entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T09:44:45+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderProductMapperImpl implements OrderProductMapper {

    @Override
    public OrderProductDTO orderProductToOrderProductDTO(OrderHasProduct orderHasProduct) {
        if ( orderHasProduct == null ) {
            return null;
        }

        OrderProductDTO orderProductDTO = new OrderProductDTO();

        orderProductDTO.setAmount( orderHasProduct.getAmount() );
        orderProductDTO.setId( orderHasProductIdToOrderProductIdDTO( orderHasProduct.getId() ) );
        orderProductDTO.setProduct( productToProductsOrderDTO( orderHasProduct.getProduct() ) );

        return orderProductDTO;
    }

    @Override
    public OrderHasProduct orderProductDTOToOrderProduct(OrderProductDTO orderProductId) {
        if ( orderProductId == null ) {
            return null;
        }

        OrderHasProduct orderHasProduct = new OrderHasProduct();

        orderHasProduct.setId( orderProductIdDTOToOrderHasProductId( orderProductId.getId() ) );
        orderHasProduct.setAmount( orderProductId.getAmount() );

        return orderHasProduct;
    }

    protected OrderProductIdDTO orderHasProductIdToOrderProductIdDTO(OrderHasProductId orderHasProductId) {
        if ( orderHasProductId == null ) {
            return null;
        }

        OrderProductIdDTO orderProductIdDTO = new OrderProductIdDTO();

        orderProductIdDTO.setOrderId( orderHasProductId.getOrderId() );
        orderProductIdDTO.setProductId( orderHasProductId.getProductId() );

        return orderProductIdDTO;
    }

    protected ProductsOrderDTO productToProductsOrderDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductsOrderDTO productsOrderDTO = new ProductsOrderDTO();

        productsOrderDTO.setDescription( product.getDescription() );
        productsOrderDTO.setId( product.getId() );
        productsOrderDTO.setName( product.getName() );
        productsOrderDTO.setPrice( product.getPrice() );

        return productsOrderDTO;
    }

    protected OrderHasProductId orderProductIdDTOToOrderHasProductId(OrderProductIdDTO orderProductIdDTO) {
        if ( orderProductIdDTO == null ) {
            return null;
        }

        OrderHasProductId orderHasProductId = new OrderHasProductId();

        if ( orderProductIdDTO.getOrderId() != null ) {
            orderHasProductId.setOrderId( orderProductIdDTO.getOrderId() );
        }
        if ( orderProductIdDTO.getProductId() != null ) {
            orderHasProductId.setProductId( orderProductIdDTO.getProductId() );
        }

        return orderHasProductId;
    }
}
