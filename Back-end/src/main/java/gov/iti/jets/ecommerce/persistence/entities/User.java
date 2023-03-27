package gov.iti.jets.ecommerce.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", catalog = "ecommerce", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "user_name") })
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements java.io.Serializable , UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "user_name", unique = true, nullable = false, length = 45)

    private String username;
    @Column(name = "email", unique = true, nullable = false, length = 150)

    private String email;
    @Column(name = "password", nullable = false, length = 255)

    private String password;
    @Column(name = "phone", length = 20)

    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
