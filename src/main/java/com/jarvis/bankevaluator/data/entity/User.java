package com.jarvis.bankevaluator.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
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
//@Builder
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
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
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "business_unit_id")
  private List<BusinessUnit> businessUnits;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return businessUnits.stream().map(businessUnit ->
                    new SimpleGrantedAuthority(businessUnit.getBusinessUnit())).
            toList();
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
