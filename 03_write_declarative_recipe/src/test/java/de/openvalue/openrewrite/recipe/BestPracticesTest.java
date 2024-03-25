package de.openvalue.openrewrite.recipe;

import org.junit.jupiter.api.Test;
import org.openrewrite.InMemoryExecutionContext;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.*;

public class BestPracticesTest implements RewriteTest {

  @Override
  public void defaults(RecipeSpec spec) {
    spec.parser(JavaParser.fromJavaVersion()
                          .classpathFromResources(new InMemoryExecutionContext(), "junit-4.13"))
        .recipe(RewriteTest.fromRuntimeClasspath("de.openvalue.openrewrite.recipe.BestPractices"));
  }

  @Test
  void renamePackage() {
    rewriteRun(
      java(
        """
              package de.openvalue.openrevrite;
            
              class A {}
          """,
        """
              package de.openvalue.openrewrite;
            
              class A {}
          """
      )
    );
  }

  @Test
  void migrateJUnit() {
    rewriteRun(
      java(
        """
              import org.junit.Assert;
              import org.junit.Test;
              
              public class MyTest {
              
                @Test
                public void testAdd() {
                  Assert.assertEquals(true, true);
                }
              }
          """,
        """
              import org.junit.jupiter.api.Assertions;
              import org.junit.jupiter.api.Test;
              
              public class MyTest {
              
                @Test
                public void testAdd() {
                  Assertions.assertEquals(true, true);
                }
              }
          """
      )
    );
  }

  @Test
  void removeUnusedImports() {
    rewriteRun(
      java(
        """
              import java.util.Map;
              
              public class A {
              }
          """,
        """
              public class A {
              }
          """
      )
    );
  }

}
