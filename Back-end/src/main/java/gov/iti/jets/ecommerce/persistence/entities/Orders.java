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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders", catalog = "ecommerce")
public class Orders implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    private Address address;

    @Column(name = "total_price", precision = 22, scale = 0)
    private Double totalPrice = 0.0;

    @Column(name = "is_submitted")
    private Boolean isSubmitted = false;

    @Column(name = "payment_type", length = 45)
    private String paymentType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submit_date", length = 19)
    private Timestamp submitDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private Set<OrderHasProduct> orderHasProducts = new HashSet<OrderHasProduct>(0);

    public Orders() {
    }

    public Orders(Customer customer) {
        this.customer = customer;
    }

    public Orders(Customer customer, Address address, Double totalPrice, Boolean isSubmitted, String paymentType,
            Timestamp submitDate, Set<OrderHasProduct> orderHasProducts) {
        this.customer = customer;
        this.address = address;
        this.totalPrice = totalPrice;
        this.isSubmitted = isSubmitted;
        this.paymentType = paymentType;
        this.submitDate = submitDate;
        this.orderHasProducts = orderHasProducts;
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


    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Boolean getIsSubmitted() {
        return this.isSubmitted;
    }

    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }


    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }


    public Timestamp getSubmitDate() {
        return this.submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }


    public Set<OrderHasProduct> getOrderHasProducts() {
        return this.orderHasProducts;
    }

    public void setOrderHasProducts(Set<OrderHasProduct> orderHasProducts) {
        this.orderHasProducts = orderHasProducts;
    }

}
