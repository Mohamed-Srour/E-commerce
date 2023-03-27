package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderHasProductId implements java.io.Serializable {

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    public OrderHasProductId() {
    }

    public OrderHasProductId(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }


    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrderHasProductId))
            return false;
        OrderHasProductId castOther = (OrderHasProductId) other;

        return (this.getOrderId() == castOther.getOrderId())
                && (this.getProductId() == castOther.getProductId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrderId();
        result = 37 * result + this.getProductId();
        return result;
    }

}
