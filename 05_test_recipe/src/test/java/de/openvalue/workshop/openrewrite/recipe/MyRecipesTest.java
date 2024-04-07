package de.openvalue.workshop.openrewrite.recipe;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;


public class MyRecipesTest implements RewriteTest {

  @Override
  public void defaults(RecipeSpec spec) {
    // Add MyRecipes as recipe to spec (see RewriteTest.fromRuntimeClasspath to load a declarative recipe)
  }

  @Test
  void doesRenamePackage() {
    // Create a test with a Java Spec with the package name that should be renamed
  }

  @Test
  void doesNotRenameOtherPackage() {
    // Create a test with a Java Spec with a different package name that should not be renamed
  }

  @Test
  void doesNotDowngradeSpringBootVersion() {
    // create a test with a POM Spec (see org.openrewrite.maven.Assertions.pomXml) with a newer version of Spring Boot than defined in the recipe
  }

  @Test
  void doesUpgradeSpringBootVersion() {
    // create a test with a POM Spec with an older Spring Boot version (e.g. 3.1.10) to be upgraded to a newer one
  }

  @Test
  void doesRemoveUnusedImports() {
    // Create a test with a Java Spec with an used import
  }

  @Test
  void doesNotRemoveUsedImports() {
    // Create a test with a Java Spec (see org.openrewrite.java.Assertions.java) with an import that is actually used and should not be changed
  }
}
