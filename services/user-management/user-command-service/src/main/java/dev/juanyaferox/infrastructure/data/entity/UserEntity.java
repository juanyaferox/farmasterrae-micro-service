package dev.juanyaferox.infrastructure.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table (name = "users")
@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString (onlyExplicitlyIncluded = true)
@Where (clause = "DELETED_AT IS NULL") // Deprecated, pero más sencillo
public class UserEntity implements /*UserDetails,*/ Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column (name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    @EqualsAndHashCode.Include
    @ToString.Include
    UUID id;

    @Column (name = "USERNAME", unique = true)
    String username;

    @Column (name = "FULL_NAME")
    String fullName;

    @Column (name = "PASSWORD")
    String password;

    @Column (name = "EMAIL", unique = true)
    String email;

    @Column (name = "PHONE")
    String phone;

    @Column (name = "ADDRESS")
    String address;

    @Column (name = "DELETED_AT")
    LocalDateTime deletedAt;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "profile_id", nullable = true)
    ProfileEntity profile;

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
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_"/* + profile.getType()*/));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }
}
