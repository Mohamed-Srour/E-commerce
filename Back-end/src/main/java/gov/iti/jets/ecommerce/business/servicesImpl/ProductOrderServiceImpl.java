package gov.iti.jets.ecommerce.business.servicesImpl;

import gov.iti.jets.ecommerce.persistence.repositories.OrderHasProductRepo;
import org.springframework.stereotype.Service;
import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;
import gov.iti.jets.ecommerce.business.mappers.OrderProductMapper;
import gov.iti.jets.ecommerce.business.services.ProductOrderService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final OrderHasProductRepo orderHasProductRepo;
    private final OrderProductMapper orderProductMapper;

    public ProductOrderServiceImpl( OrderHasProductRepo orderHasProductRepo, OrderProductMapper orderProductMapper) {
        this.orderHasProductRepo = orderHasProductRepo;
        this.orderProductMapper = orderProductMapper;
    }


    @Override
    public void updateProductOrder(OrderProductDTO ordersDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProductOrder'");
    }

    @Override
    public void addProductOrder(OrderProductDTO ordersDTO) {
       this.orderHasProductRepo.save(this.orderProductMapper.orderProductDTOToOrderProduct(ordersDTO));
    }

    @Override
    public void deleteProductOrder(OrderProductDTO ordersDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductOrder'");
    }



    @Override
    public Integer chickProductAddedToCart(Integer productId, Integer orderId) {
        return this.orderHasProductRepo.chickProductAddedToCart(productId, orderId);
    }


    @Override
    public void deleteProductFromCart(Integer productId, Integer orderId) {
        this.orderHasProductRepo.deleteProductFromCart(productId, orderId);
    }
    
}
