package de.openvalue.workshop.closedrewrite;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest
{
   @Test
   public void testAdd() {
      final var calculator = new Calculator();
      final var result = calculator.add( 2, 4 );

      assertEquals( 6, result );
   }
   @Test
   public void testSubtract() {
      final var calculator = new Calculator();
      final var result = calculator.subtract( 2, 4 );

      assertEquals( -2, result );
   }
   @Test
   public void testMultiply() {
      final var calculator = new Calculator();
      final var result = calculator.multiply( 2, 4 );

      assertEquals( 8, result );
   }
   @Test
   public void testDivide() {
      final var calculator = new Calculator();
      final var result = calculator.device( 4, 2 );

      assertEquals( 2, result );
   }
}
