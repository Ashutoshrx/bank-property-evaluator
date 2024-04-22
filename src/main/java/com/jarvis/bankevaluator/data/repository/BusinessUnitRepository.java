package com.jarvis.bankevaluator.data.repository;

import com.jarvis.bankevaluator.data.entity.BusinessUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, Integer> {
}
