package dev.juanyaferox.user.infrastructure.data.entity;

import dev.juanyaferox.profile.infrastructure.data.entity.Profile;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Entity
@Table (name = "users")
@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString (onlyExplicitlyIncluded = true)
@Where (clause = "deletedAt IS NULL") // Deprecated, pero más sencillo
public class UserEntity implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column (name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    @EqualsAndHashCode.Include
    @ToString.Include
    UUID id;

    @Column (unique = true)
    String username;

    String fullName;

    String password;

    @Column (unique = true)
    String email;

    String phone;

    String address;

    LocalDateTime deletedAt;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "profile_id", nullable = false)
    Profile profile;

    //    @OneToMany (mappedBy = "userModified", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @ToString.Exclude
//    List<Product> productList;
//
//    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @ToString.Exclude
//    List<Order> orderList;
//
//    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @ToString.Exclude
//    List<Review> reviewList;
//
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"/* + profile.getType()*/));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
