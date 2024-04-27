package com.jarvis.bankevaluator.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<T> {
  @CreatedDate
  @Column(name = "created_ts", updatable = false, nullable = false)
  private LocalDateTime createDate;
  @LastModifiedDate
  @Column(name = "updated_ts", updatable = false, nullable = false)
  private LocalDateTime updatedDate;
}
