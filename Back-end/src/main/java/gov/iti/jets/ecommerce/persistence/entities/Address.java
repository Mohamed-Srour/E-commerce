package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address", catalog = "ecommerce")
public class Address implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "area", length = 150)
    private String area;

    @Column(name = "building_num")
    private Integer buildingNum;

    @Column(name = "floor_num")
    private Integer floorNum;
    @Column(name = "street", length = 150)
    private String street;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<Orders> orderses = new HashSet<Orders>(0);

    public Address() {
    }

    public Address(Customer customer) {
        this.customer = customer;
    }

    public Address(Customer customer, String area, Integer buildingNum, Integer floorNum, String street,
            Set<Orders> orderses) {
        this.customer = customer;
        this.area = area;
        this.buildingNum = buildingNum;
        this.floorNum = floorNum;
        this.street = street;
        this.orderses = orderses;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public Integer getBuildingNum() {
        return this.buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }


    public Integer getFloorNum() {
        return this.floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }


    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
