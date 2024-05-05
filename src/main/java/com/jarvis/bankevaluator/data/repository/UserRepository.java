package com.jarvis.bankevaluator.data.repository;

import com.jarvis.bankevaluator.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByInitiatorNameAndPassword(String initiatorName,String password);

  Optional<User> findByInitiatorName(String initiatorName);
  Optional<User> findByContactNumber(String contactNumber);
}

