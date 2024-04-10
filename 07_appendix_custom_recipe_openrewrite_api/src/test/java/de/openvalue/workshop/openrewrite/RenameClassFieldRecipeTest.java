package de.openvalue.workshop.openrewrite;

import static org.openrewrite.java.Assertions.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

public class RenameClassFieldRecipeTest
   implements RewriteTest
{
   @Override
   public void defaults( final RecipeSpec spec )
   {
      spec.recipe( new RenameClassFieldRecipe( "x", "y" ) );
   }

   @Test
   void renameFieldRenamesFoundField()
   {
      rewriteRun(
         java(
            """
            package my.test;

            class A
            {
               private final String x = "A";
               int add(final int x, final int y)
               {
                  return x+y;
               }
            }
            """,
            """
            package my.test;

            class A
            {
               private final String y = "A";
               int add(final int x, final int y)
               {
                  return x+y;
               }
            }
            """
         )
      );
   }

   @Test
   void renameFieldRenamesFoundFieldAndUsage()
   {
      rewriteRun(
         java(
            """
            package my.test;

            class A
            {
               private final String x = "A";

               int add(final int x, final int y)
               {
                  return x+y;
               }

               void printY() {
                  System.out.println(x);
               }
            }
            """,
            """
            package my.test;

            class A
            {
               private final String y = "A";

               int add(final int x, final int y)
               {
                  return x+y;
               }

               void printY() {
                  System.out.println(y);
               }
            }
            """
         )
      );
   }
}
