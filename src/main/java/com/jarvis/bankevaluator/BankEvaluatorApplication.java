package com.jarvis.bankevaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankEvaluatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankEvaluatorApplication.class, args);
  }

}
