package gov.iti.jets.ecommerce.persistence.repositories;

import gov.iti.jets.ecommerce.persistence.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = " select * from product where name like name ", nativeQuery = true)
    Product getProductByName(String name);

    @Query(value = " select count(*) from product where id = ? and stock < ? ", nativeQuery = true )
    Integer checkStockProduct(Integer productId, Integer amount);

    @Modifying
    @Transactional
    @Query(value = "update product set stock = stock - ? where id = ?", nativeQuery = true)
    void updateStock(Integer amount, Integer id);

    @Query(value = "From Product p WHERE p.isDeleted = false order by p.name")
    List<Product> findAllProducts();

    @Query(value = "From Product p WHERE p.isDeleted = false")
    List<Product> findAllProductsByTime();


    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.isDeleted = true WHERE p.id = :id")
    void deleteProductById(Integer id);
}
