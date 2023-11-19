package com.mshzidan.society.entites;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "account_id_gen")
    @SequenceGenerator(name = "account_id_gen" , initialValue = 20)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)

    private String password;
    @Column(nullable = false)

    private String role;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.role);
        return Arrays.asList(grantedAuthority);
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
