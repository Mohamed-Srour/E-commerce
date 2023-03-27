package gov.iti.jets.ecommerce.business.services;

import java.util.List;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.OrdersDTO;

public interface OrdersService  {
    public List<OrdersDTO> getAllOrders();
    public OrdersDTO getOrderById(Integer id);
    public OrdersDTO addOrder(OrdersDTO ordersDTO);
    public void removeOrder(Integer id);
    public OrdersDTO getCart(Integer id);
    public void updateOrder(OrdersDTO ordersDTO);
    public List<OrdersDTO> getCustomerOrders(Integer id);
    public void addAddress(AddressDTO addressDTO);
    public List<AddressDTO> getAddressForCustomer(Integer id);
}
