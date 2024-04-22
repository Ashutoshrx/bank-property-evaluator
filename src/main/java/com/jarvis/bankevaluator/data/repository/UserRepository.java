package com.jarvis.bankevaluator.data.repository;

import com.jarvis.bankevaluator.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByInitiatorNameAndContactNumberAndBusinessUnitsBusinessUnit(
          String initiatorName, String contactNumber, String businessUnit);
  User findByInitiatorName(String initiatorName);
  Optional<User> findByContactNumber(String contactNumber);
}

