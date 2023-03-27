package gov.iti.jets.ecommerce.business.mappers;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import gov.iti.jets.ecommerce.business.dtos.AddressDTO;
import gov.iti.jets.ecommerce.business.dtos.CustomerDTO;
import gov.iti.jets.ecommerce.business.dtos.CustomerOrderDTO;
import gov.iti.jets.ecommerce.business.dtos.OrderHasProductDTO;
import gov.iti.jets.ecommerce.business.dtos.OrdersDTO;
import gov.iti.jets.ecommerce.business.dtos.ProductsOrderDTO;
import gov.iti.jets.ecommerce.persistence.entities.Address;
import gov.iti.jets.ecommerce.persistence.entities.Customer;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProduct;
import gov.iti.jets.ecommerce.persistence.entities.Orders;
import gov.iti.jets.ecommerce.persistence.entities.Product;

@Mapper(componentModel = "spring")
public interface OrdersMapper {

    @Mapping(target = "username" , source = "username")
    @Mapping(target = "role",source = "role")
    CustomerDTO customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);


    AddressDTO addressToAddressDTO(Address address);

    @Mapping(target = "orderses", ignore = true)
    Address addressDTOToAddress(AddressDTO address);

    List<AddressDTO> addressToAddressDTO(List<Address> address);

    List<Address> addressDTOToAddress(List<AddressDTO> address);

    CustomerOrderDTO customerToCustomerOrderDTO(Customer customer);

    @Mapping(target = "dob", ignore = true)
    @Mapping(target = "isMale", ignore = true)
    @Mapping(target = "orderses", ignore = true)
    @Mapping(target = "password", ignore = true)
    Customer customerOrderDTOToCustomer(CustomerOrderDTO customerOrderDTO);

    ProductsOrderDTO productToProductsOrderDTO(Product product);

    @Mapping(target = "rate", ignore = true)
    @Mapping(target = "stock", ignore = true)
    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "orderHasProducts", ignore = true)
    Product productsOrderDTOToProduct(ProductsOrderDTO product);

    OrderHasProductDTO orderHasProductToOrderHasProductsDTO(OrderHasProduct orderHasProduct);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    OrderHasProduct OrderHasProductsDTOToorderHasProduct(OrderHasProductDTO orderHasProduct);

    List<OrderHasProductDTO> orderHasProductToOrderHasProductsDTO(List<OrderHasProduct> orderHasProduct);

    List<OrderHasProduct> OrderHasProductsDTOToorderHasProduct(List<OrderHasProductDTO> orderHasProduct);

    @Mapping(target = "addressDTO", source = "address")
    @Mapping(target = "customerOrderDTO", source = "customer")
    @Mapping(target = "orderHasProductsDTO", source = "orderHasProducts")
    OrdersDTO orderToOrderDTO(Orders orders);

    @InheritInverseConfiguration
    Orders orderDTOToOrder(OrdersDTO orderDto);

    List<OrdersDTO> orderToOrderDTO(List<Orders> orders);

    List<Orders> orderDTOToOrder(List<OrdersDTO> orderDto);
}
