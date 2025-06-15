package dev.juanyaferox.profile.infrastructure.data.entity;

import dev.juanyaferox.infrastructure.data.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table (name = "profiles")
public class Profile implements GrantedAuthority, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column (unique = true)
    String type;

    String description;

    @OneToMany (mappedBy = "profile", fetch = FetchType.LAZY)
    @ToString.Exclude
    List<User> userList;

    @Override
    public String getAuthority() {
        return type;
    }
}
