package gov.iti.jets.ecommerce.business.servicesImpl;
import java.util.List;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.OrdersDTO;
import gov.iti.jets.ecommerce.business.mappers.OrdersMapper;
import gov.iti.jets.ecommerce.business.services.OrdersService;
import gov.iti.jets.ecommerce.exceptions.ResourceNotFoundException;
import gov.iti.jets.ecommerce.persistence.repositories.AddressRepo;
import gov.iti.jets.ecommerce.persistence.repositories.OrdersRepo;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepo ordersRepo;
    private final OrdersMapper ordersMapper;
    private final AddressRepo addressRepo;

    public OrdersServiceImpl(OrdersRepo ordersRepo,OrdersMapper ordersMapper, AddressRepo addressRepo) {
        this.ordersRepo = ordersRepo;
        this.ordersMapper=ordersMapper;
        this.addressRepo = addressRepo;
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return ordersMapper.orderToOrderDTO(ordersRepo.getAllOrders());
    }

    @Override
    public OrdersDTO getOrderById(Integer id) {
        return ordersMapper.orderToOrderDTO(ordersRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public OrdersDTO addOrder(OrdersDTO ordersDTO) {
        return ordersMapper.orderToOrderDTO(ordersRepo.save(ordersMapper.orderDTOToOrder(ordersDTO)));
    }

    @Override
    public void removeOrder(Integer id) {
        ordersRepo.deleteById(id);
    }

    @Override
    public OrdersDTO getCart(Integer id) {
       return ordersMapper.orderToOrderDTO(ordersRepo.getCart(id));
    }

    @Override
    public void updateOrder(OrdersDTO ordersDTO) {
        ordersRepo.save(ordersMapper.orderDTOToOrder(ordersDTO));
    }

    @Override
    public List<OrdersDTO> getCustomerOrders(Integer id) {
       return ordersMapper.orderToOrderDTO(ordersRepo.getCustomerOrders(id));
    }

    @Override
    public void addAddress(AddressDTO addressDTO) {
        this.addressRepo.save(ordersMapper.addressDTOToAddress(addressDTO));
    }

    @Override
    public List<AddressDTO> getAddressForCustomer(Integer id) {
        return ordersMapper.addressToAddressDTO( this.addressRepo.getAddressFprCustomer(id));
    }
}
