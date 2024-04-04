package de.openvalue.workshop.openrewrite;

import de.openvalue.workshop.closedrewrite.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration
{
   @Bean
   public Calculator calculator() {
      return new Calculator();
   }
}
