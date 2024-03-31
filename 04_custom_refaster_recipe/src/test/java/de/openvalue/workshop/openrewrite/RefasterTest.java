package de.openvalue.workshop.openrewrite;

import static org.openrewrite.java.Assertions.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

public class RefasterTest implements RewriteTest {
  @Test
  void testRecipe() {
    rewriteRun(
      spec -> spec.recipe(new SimplifyTernaryRecipe()),
      java("""
          package my.test;
                                  
          class TestClass {
             public boolean isEven(int number) {
                return number % 2 == 0 ? true : false;
             }
          }
          """,
        """
          package my.test;
                                  
          class TestClass {
             public boolean isEven(int number) {
                return number % 2 == 0;
             }
          }
          """));
  }
}
