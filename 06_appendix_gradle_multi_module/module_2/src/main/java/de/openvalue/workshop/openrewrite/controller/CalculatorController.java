package de.openvalue.workshop.openrewrite.controller;

import de.openvalue.workshop.closedrewrite.Calculator;
import de.openvalue.workshop.openrewrite.domain.CaclulateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorController
{
   private final Calculator calculator;

   public CalculatorController( Calculator calculator ) {

      this.calculator = calculator;
   }
   @PostMapping("add")
   public int add( @RequestBody CaclulateRequest caclulateRequest ) {
      return calculator.add( caclulateRequest.a(), caclulateRequest.b());
   }
   @PostMapping("subtract")
   public int subtract( @RequestBody CaclulateRequest caclulateRequest ) {
      return calculator.subtract( caclulateRequest.a(), caclulateRequest.b());
   }
   @PostMapping("multiply")
   public int multiply( @RequestBody CaclulateRequest caclulateRequest ) {
      return calculator.multiply( caclulateRequest.a(), caclulateRequest.b());
   }
   @PostMapping("divide")
   public int divide( @RequestBody CaclulateRequest caclulateRequest ) {
      return calculator.device( caclulateRequest.a(), caclulateRequest.b());
   }
}
