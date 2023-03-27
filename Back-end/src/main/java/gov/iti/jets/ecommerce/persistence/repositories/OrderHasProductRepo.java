package gov.iti.jets.ecommerce.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import gov.iti.jets.ecommerce.persistence.entities.OrderHasProduct;
import gov.iti.jets.ecommerce.persistence.entities.OrderHasProductId;

public interface OrderHasProductRepo extends JpaRepository<OrderHasProduct, OrderHasProductId> {
 
    @Query(value="select count(*) from order_has_product where product_id = ? and order_id = ?", nativeQuery = true)
    public Integer chickProductAddedToCart(Integer productId, Integer orderId);

    @Modifying
    @Transactional
    @Query(value = "delete from order_has_product where product_id = ? and order_id = ?", nativeQuery = true)
    public void deleteProductFromCart(Integer productId, Integer orderId);
}
