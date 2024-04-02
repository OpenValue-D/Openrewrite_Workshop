package de.openvalue.workshop.openrevrite;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

public class MathUtils {
  private MathUtils() {
  }

  public static int add(int x, int y) {
    return x + y;
  }

  public static int subtract(int x, int y) {
    return x - y;
  }

  public static int divide(int x, int y) {
    if (y == 0) {
      throw new ArithmeticException("y can not be 0");
    }
    return x / y;
  }

  public static int factorial(int x) {
    if (x < 0) {
      throw new ArithmeticException("factorial does not allow negative numbers");
    }

    int result = 1;
    for (int i = x; i > 0; i--) {
      result = result * i;
    }
    return result;
  }
}
