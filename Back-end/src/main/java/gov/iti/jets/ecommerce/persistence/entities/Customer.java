package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customer", catalog = "ecommerce")
public class Customer extends User {
    @Column(name = "is_male")
    private Boolean isMale;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;
    @Column(name = "wallet_limit", nullable = false, precision = 22, scale = 0)
    private double walletLimit = 0.0;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Address> addresses = new HashSet<Address>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Orders> orderses = new HashSet<Orders>(0);

    public Customer() {
    }


    public Customer(double walletLimit) {
        this.walletLimit = walletLimit;
    }

    public Customer(Boolean isMale, Date dob, double walletLimit, Set<Address> addresses, Set<Orders> orderses) {

        this.isMale = isMale;
        this.dob = dob;
        this.walletLimit = walletLimit;
        this.addresses = addresses;
        this.orderses = orderses;
    }


    public Boolean getIsMale() {
        return this.isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getWalletLimit() {
        return this.walletLimit;
    }

    public void setWalletLimit(double walletLimit) {
        this.walletLimit = walletLimit;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
