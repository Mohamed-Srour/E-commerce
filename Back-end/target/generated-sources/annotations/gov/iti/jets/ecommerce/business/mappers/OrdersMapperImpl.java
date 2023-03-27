package gov.iti.jets.ecommerce.business.mappers;

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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T09:44:45+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public CustomerDTO customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setUsername( customer.getUsername() );
        customerDTO.setRole( customer.getRole() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setId( customer.getId() );
        customerDTO.setIsMale( customer.getIsMale() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setWalletLimit( customer.getWalletLimit() );

        return customerDTO;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setEmail( customerDTO.getEmail() );
        customer.setId( customerDTO.getId() );
        customer.setPhone( customerDTO.getPhone() );
        customer.setRole( customerDTO.getRole() );
        customer.setUsername( customerDTO.getUsername() );
        customer.setIsMale( customerDTO.getIsMale() );
        customer.setWalletLimit( customerDTO.getWalletLimit() );

        return customer;
    }

    @Override
    public AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setArea( address.getArea() );
        addressDTO.setBuildingNum( address.getBuildingNum() );
        addressDTO.setCustomer( customerToCustomerDto( address.getCustomer() ) );
        addressDTO.setFloorNum( address.getFloorNum() );
        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );

        return addressDTO;
    }

    @Override
    public Address addressDTOToAddress(AddressDTO address) {
        if ( address == null ) {
            return null;
        }

        Address address1 = new Address();

        address1.setId( address.getId() );
        address1.setCustomer( customerDtoToCustomer( address.getCustomer() ) );
        address1.setArea( address.getArea() );
        address1.setBuildingNum( address.getBuildingNum() );
        address1.setFloorNum( address.getFloorNum() );
        address1.setStreet( address.getStreet() );

        return address1;
    }

    @Override
    public List<AddressDTO> addressToAddressDTO(List<Address> address) {
        if ( address == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( address.size() );
        for ( Address address1 : address ) {
            list.add( addressToAddressDTO( address1 ) );
        }

        return list;
    }

    @Override
    public List<Address> addressDTOToAddress(List<AddressDTO> address) {
        if ( address == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( address.size() );
        for ( AddressDTO addressDTO : address ) {
            list.add( addressDTOToAddress( addressDTO ) );
        }

        return list;
    }

    @Override
    public CustomerOrderDTO customerToCustomerOrderDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();

        customerOrderDTO.setAddresses( addressSetToAddressDTOSet( customer.getAddresses() ) );
        customerOrderDTO.setEmail( customer.getEmail() );
        customerOrderDTO.setId( customer.getId() );
        customerOrderDTO.setPhone( customer.getPhone() );
        customerOrderDTO.setRole( customer.getRole() );
        customerOrderDTO.setUsername( customer.getUsername() );
        customerOrderDTO.setWalletLimit( customer.getWalletLimit() );

        return customerOrderDTO;
    }

    @Override
    public Customer customerOrderDTOToCustomer(CustomerOrderDTO customerOrderDTO) {
        if ( customerOrderDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setEmail( customerOrderDTO.getEmail() );
        customer.setId( customerOrderDTO.getId() );
        customer.setPhone( customerOrderDTO.getPhone() );
        customer.setRole( customerOrderDTO.getRole() );
        customer.setUsername( customerOrderDTO.getUsername() );
        customer.setWalletLimit( customerOrderDTO.getWalletLimit() );
        customer.setAddresses( addressDTOSetToAddressSet( customerOrderDTO.getAddresses() ) );

        return customer;
    }

    @Override
    public ProductsOrderDTO productToProductsOrderDTO(Product product) {
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

    @Override
    public Product productsOrderDTOToProduct(ProductsOrderDTO product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setId( product.getId() );
        product1.setName( product.getName() );
        product1.setDescription( product.getDescription() );
        product1.setPrice( product.getPrice() );

        return product1;
    }

    @Override
    public OrderHasProductDTO orderHasProductToOrderHasProductsDTO(OrderHasProduct orderHasProduct) {
        if ( orderHasProduct == null ) {
            return null;
        }

        OrderHasProductDTO orderHasProductDTO = new OrderHasProductDTO();

        orderHasProductDTO.setAmount( orderHasProduct.getAmount() );
        orderHasProductDTO.setProduct( productToProductsOrderDTO( orderHasProduct.getProduct() ) );

        return orderHasProductDTO;
    }

    @Override
    public OrderHasProduct OrderHasProductsDTOToorderHasProduct(OrderHasProductDTO orderHasProduct) {
        if ( orderHasProduct == null ) {
            return null;
        }

        OrderHasProduct orderHasProduct1 = new OrderHasProduct();

        orderHasProduct1.setProduct( productsOrderDTOToProduct( orderHasProduct.getProduct() ) );
        orderHasProduct1.setAmount( orderHasProduct.getAmount() );

        return orderHasProduct1;
    }

    @Override
    public List<OrderHasProductDTO> orderHasProductToOrderHasProductsDTO(List<OrderHasProduct> orderHasProduct) {
        if ( orderHasProduct == null ) {
            return null;
        }

        List<OrderHasProductDTO> list = new ArrayList<OrderHasProductDTO>( orderHasProduct.size() );
        for ( OrderHasProduct orderHasProduct1 : orderHasProduct ) {
            list.add( orderHasProductToOrderHasProductsDTO( orderHasProduct1 ) );
        }

        return list;
    }

    @Override
    public List<OrderHasProduct> OrderHasProductsDTOToorderHasProduct(List<OrderHasProductDTO> orderHasProduct) {
        if ( orderHasProduct == null ) {
            return null;
        }

        List<OrderHasProduct> list = new ArrayList<OrderHasProduct>( orderHasProduct.size() );
        for ( OrderHasProductDTO orderHasProductDTO : orderHasProduct ) {
            list.add( OrderHasProductsDTOToorderHasProduct( orderHasProductDTO ) );
        }

        return list;
    }

    @Override
    public OrdersDTO orderToOrderDTO(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setAddressDTO( addressToAddressDTO( orders.getAddress() ) );
        ordersDTO.setCustomerOrderDTO( customerToCustomerOrderDTO( orders.getCustomer() ) );
        ordersDTO.setOrderHasProductsDTO( orderHasProductSetToOrderHasProductDTOSet( orders.getOrderHasProducts() ) );
        ordersDTO.setId( orders.getId() );
        ordersDTO.setIsSubmitted( orders.getIsSubmitted() );
        ordersDTO.setPaymentType( orders.getPaymentType() );
        ordersDTO.setSubmitDate( orders.getSubmitDate() );
        ordersDTO.setTotalPrice( orders.getTotalPrice() );

        return ordersDTO;
    }

    @Override
    public Orders orderDTOToOrder(OrdersDTO orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setAddress( addressDTOToAddress( orderDto.getAddressDTO() ) );
        orders.setCustomer( customerOrderDTOToCustomer( orderDto.getCustomerOrderDTO() ) );
        orders.setOrderHasProducts( orderHasProductDTOSetToOrderHasProductSet( orderDto.getOrderHasProductsDTO() ) );
        orders.setId( orderDto.getId() );
        orders.setTotalPrice( orderDto.getTotalPrice() );
        orders.setIsSubmitted( orderDto.getIsSubmitted() );
        orders.setPaymentType( orderDto.getPaymentType() );
        if ( orderDto.getSubmitDate() != null ) {
            orders.setSubmitDate( new Timestamp( orderDto.getSubmitDate().getTime() ) );
        }

        return orders;
    }

    @Override
    public List<OrdersDTO> orderToOrderDTO(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrdersDTO> list = new ArrayList<OrdersDTO>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( orderToOrderDTO( orders1 ) );
        }

        return list;
    }

    @Override
    public List<Orders> orderDTOToOrder(List<OrdersDTO> orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        List<Orders> list = new ArrayList<Orders>( orderDto.size() );
        for ( OrdersDTO ordersDTO : orderDto ) {
            list.add( orderDTOToOrder( ordersDTO ) );
        }

        return list;
    }

    protected Set<AddressDTO> addressSetToAddressDTOSet(Set<Address> set) {
        if ( set == null ) {
            return null;
        }

        Set<AddressDTO> set1 = new LinkedHashSet<AddressDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Address address : set ) {
            set1.add( addressToAddressDTO( address ) );
        }

        return set1;
    }

    protected Set<Address> addressDTOSetToAddressSet(Set<AddressDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Address> set1 = new LinkedHashSet<Address>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AddressDTO addressDTO : set ) {
            set1.add( addressDTOToAddress( addressDTO ) );
        }

        return set1;
    }

    protected Set<OrderHasProductDTO> orderHasProductSetToOrderHasProductDTOSet(Set<OrderHasProduct> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderHasProductDTO> set1 = new LinkedHashSet<OrderHasProductDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderHasProduct orderHasProduct : set ) {
            set1.add( orderHasProductToOrderHasProductsDTO( orderHasProduct ) );
        }

        return set1;
    }

    protected Set<OrderHasProduct> orderHasProductDTOSetToOrderHasProductSet(Set<OrderHasProductDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderHasProduct> set1 = new LinkedHashSet<OrderHasProduct>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderHasProductDTO orderHasProductDTO : set ) {
            set1.add( OrderHasProductsDTOToorderHasProduct( orderHasProductDTO ) );
        }

        return set1;
    }
}
