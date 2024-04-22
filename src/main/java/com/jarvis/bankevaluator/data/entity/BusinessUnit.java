package com.jarvis.bankevaluator.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
@Table(name = "business_unit")
@EntityListeners(AuditingEntityListener.class)
public class BusinessUnit extends BaseEntity<BusinessUnit> {
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;
  @Column(name = "business_unit", nullable = false)
  private String businessUnit;
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User users;
}
