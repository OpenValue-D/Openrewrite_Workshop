package de.openvalue.openrevrite.workshop;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

public class MathUtilsTest {

  @Test
  public void testAdd() {
    Assert.assertEquals(2, MathUtils.add(1, 1));
  }

  @Test
  public void testAddNegativeNumber() {
    Assert.assertEquals(0, MathUtils.add(1, -1));
  }

  @Test
  public void testSubtract() {
    Assert.assertEquals(2, MathUtils.subtract(4, 2));
  }

  @Test(expected = ArithmeticException.class)
  public void testDivideByZero() {
    MathUtils.divide(2, 0);
  }

  @Test
  public void testFactorial() {
    Assert.assertEquals(24, MathUtils.factorial(4));
  }

  @Test
  @Category(SlowTest.class)
  public void testFactorialWithBigNumber() {
    Assert.assertEquals(1409286144, MathUtils.factorial(30));
  }

  @Test
  @Ignore("should be refactored to throw exception")
  public void testFactorialWithTooBigNumber() {
    Assert.assertEquals(0 , MathUtils.factorial(170));
  }

}