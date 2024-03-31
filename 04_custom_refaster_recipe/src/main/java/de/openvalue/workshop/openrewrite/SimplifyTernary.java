package de.openvalue.workshop.openrewrite;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

public class SimplifyTernary
{
   @BeforeTemplate
   boolean before(boolean expr) {
      return expr ? true : false;
   }

   @AfterTemplate
   boolean after(boolean expr) {
      return expr;
   }
}
