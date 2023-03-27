package gov.iti.jets.ecommerce.business.services;

import gov.iti.jets.ecommerce.business.dtos.OrderProductDTO;

public interface ProductOrderService {

    public void updateProductOrder(OrderProductDTO ordersDTO);
    public void addProductOrder(OrderProductDTO ordersDTO);
    public void deleteProductOrder(OrderProductDTO ordersDTO);
    public Integer chickProductAddedToCart(Integer productId, Integer orderId);
    public void deleteProductFromCart(Integer productId, Integer orderId);

}
