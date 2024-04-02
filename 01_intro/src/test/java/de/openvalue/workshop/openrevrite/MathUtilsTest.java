package de.openvalue.workshop.openrevrite;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class MathUtilsTest {

  @Test
  public void testAdd() {
    assertEquals(2, MathUtils.add(1, 1));
  }

  @Test
  public void testAddNegativeNumber() {
    assertEquals(0, MathUtils.add(1, -1));
  }

  @Test
  public void testSubtract() {
    assertEquals(2, MathUtils.subtract(4, 2));
  }

  @Test(expected = ArithmeticException.class)
  public void testDivideByZero() {
    MathUtils.divide(2, 0);
  }

  @Test
  public void testFactorial() {
    assertEquals(24, MathUtils.factorial(4));
  }

  @Test
  @Category(SlowTest.class)
  public void testFactorialWithBigNumber() {
    assertEquals(1409286144, MathUtils.factorial(30));
  }

  @Test
  @Ignore("should be refactored to throw exception")
  public void testFactorialWithTooBigNumber() {
    assertEquals(0 , MathUtils.factorial(170));
  }

}