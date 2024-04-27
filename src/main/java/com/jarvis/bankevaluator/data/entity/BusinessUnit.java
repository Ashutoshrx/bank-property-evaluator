package com.jarvis.bankevaluator.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "business_unit")
@EntityListeners(AuditingEntityListener.class)
public class BusinessUnit extends BaseEntity<BusinessUnit> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "business_unit_id", nullable = false)
  private Integer businessUnitId;
  @Column(name = "business_unit", nullable = false, unique = true)
  private String businessUnit;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessUnit")
  private List<User> users;
}
