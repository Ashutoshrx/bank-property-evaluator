package com.jarvis.bankevaluator.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity<User> implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "initiator_name", nullable = false)
  private String initiatorName;
  @Column(name = "contact_number", length = 10, unique = true, nullable = false)
  private String contactNumber;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "accountLocked", nullable = false)
  private boolean accountLocked;
  @Column(name = "enabled", nullable = false)
  private boolean enabled;
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "business_unit_id", nullable = false)
  private BusinessUnit businessUnit;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(businessUnit.getBusinessUnit()));
  }

  @Override
  public String getUsername() {
    return initiatorName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !accountLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return enabled;
  }
}
