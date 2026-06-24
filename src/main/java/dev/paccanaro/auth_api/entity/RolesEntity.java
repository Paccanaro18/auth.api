package dev.paccanaro.auth_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RolesEntity implements GrantedAuthority {



    @Id
    private Integer id;
    private String nome;



    @Override
    public @Nullable String getAuthority() {
        return nome;
    }







}


