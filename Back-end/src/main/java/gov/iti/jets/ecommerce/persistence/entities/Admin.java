package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "admin", catalog = "ecommerce")
public class Admin extends User {

    public Admin() {
    }


}
