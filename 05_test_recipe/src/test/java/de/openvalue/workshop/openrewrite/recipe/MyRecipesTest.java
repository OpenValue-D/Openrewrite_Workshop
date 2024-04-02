package de.openvalue.workshop.openrewrite.recipe;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.*;
import static org.openrewrite.maven.Assertions.pomXml;

public class MyRecipesTest implements RewriteTest {

  @Override
  public void defaults(RecipeSpec spec) {
    // Add MyRecipes as recipe to spec (see RewriteTest.fromRuntimeClasspath to load a declarative recipe)
    spec.recipe(RewriteTest.fromRuntimeClasspath("de.openvalue.workshop.openrewrite.recipe.MyRecipes"));
  }

  @Test
  void doesRenamePackage() {
    // Create a test with a Java Spec with the package name that should be renamed
    rewriteRun(
      java(
        """
              package de.openvalue.workshop.openrevrite;
            
              class A {}
          """,
        """
              package de.openvalue.workshop.openrewrite;
            
              class A {}
          """
      )
    );
  }

  @Test
  void doesNotRenameOtherPackage() {
    // Create a test with a Java Spec with a different package name that should not be renamed
    rewriteRun(
      java(
        """
              package com.openvalue.workshop.openrevrite;
            
              class A {}
          """
      )
    );
  }

  @Test
  void doesNotDowngradeSpringBootVersion() {
    // create a test with a POM Spec (see org.openrewrite.maven.Assertions.pomXml) with a newer version of Spring Boot than defined in the recipe
    rewriteRun(
      pomXml(
        """
          <project>
            <parent>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-parent</artifactId>
              <version>3.2.4</version>
              <relativePath/>
            </parent>
            <groupId>de.openvalue.workshop.openrewrite</groupId>
            <artifactId>my-app</artifactId>
            <version>1.0.0</version>
          </project>
          """
      )
    );
  }

  @Test
  void doesUpgradeSpringBootVersion() {
    // create a test with a POM Spec with an older Spring Boot version (e.g. 3.1.10) to be upgraded to a newer one
    rewriteRun(
      pomXml(
        """
          <project>
            <parent>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-parent</artifactId>
              <version>3.1.10</version>
              <relativePath/>
            </parent>
            <groupId>de.openvalue.workshop.openrewrite</groupId>
            <artifactId>my-app</artifactId>
            <version>1.0.0</version>
          </project>
          """,
        """
          <project>
            <parent>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-parent</artifactId>
              <version>3.2.3</version>
              <relativePath/>
            </parent>
            <groupId>de.openvalue.workshop.openrewrite</groupId>
            <artifactId>my-app</artifactId>
            <version>1.0.0</version>
          </project>
          """
      )
    );
  }

  @Test
  void doesRemoveUnusedImports() {
    // Create a test with a Java Spec with an used import
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

  @Test
  void doesNotRemoveUsedImports() {
    // Create a test with a Java Spec (see org.openrewrite.java.Assertions.java) with an import that is actually used and should not be changed
    rewriteRun(
      java(
        """
              import java.util.Map;
              
              public class A {
                private static final Map<String,String> MY_MAP = Map.of("test", "test");
              }
          """
      )
    );
  }
}
