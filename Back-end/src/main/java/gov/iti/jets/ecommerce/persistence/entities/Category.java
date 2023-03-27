package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category", catalog = "ecommerce", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_deleted")
    private boolean isDeleted  = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_has_category", catalog = "ecommerce", joinColumns = {
            @JoinColumn(name = "category_id", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "product_id", nullable = false, updatable = false) })
    private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String description, Set<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
