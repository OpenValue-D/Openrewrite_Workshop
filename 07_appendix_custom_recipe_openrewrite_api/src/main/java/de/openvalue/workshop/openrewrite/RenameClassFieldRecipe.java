package de.openvalue.workshop.openrewrite;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.openrewrite.Cursor;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.JavaType;

public class RenameClassFieldRecipe
   extends Recipe
{
   private final String before;
   private final String after;

   // All recipes must be serializable. This is verified by RewriteTest.rewriteRun() in your tests.
   @JsonCreator
   public RenameClassFieldRecipe(
      @JsonProperty( "before" ) String before,
      @JsonProperty( "after" ) String after )
   {
      this.before = before;
      this.after = after;
   }

   @Override
   public String getDisplayName()
   {
      return "RenameField";
   }

   @Override
   public String getDescription()
   {
      return "Rename class field.";
   }

   @Override
   public TreeVisitor< ?, ExecutionContext > getVisitor()
   {
      return new RenameFieldVisitor();
   }

   @Override
   public boolean equals( final Object o )
   {
      if( this == o ) {
         return true;
      }
      if( getClass() != o.getClass() ) {
         return false;
      }
      if( !super.equals( o ) ) {
         return false;
      }
      final RenameClassFieldRecipe that = (RenameClassFieldRecipe)o;
      return Objects.equals( before, that.before ) && Objects.equals( after, that.after );
   }

   @Override
   public int hashCode()
   {
      return Objects.hash( before, after );
   }

   private class RenameFieldVisitor
      extends JavaIsoVisitor< ExecutionContext >
   {
      @Override
      public J.VariableDeclarations.NamedVariable visitVariable(
         final J.VariableDeclarations.NamedVariable variable,
         final ExecutionContext ctx )
      {
         final J.VariableDeclarations.NamedVariable namedVariable = super.visitVariable( variable, ctx );
         final Cursor cursor = getCursor();
         if( !variable.isField( cursor ) ) {
            return namedVariable;
         }

         final JavaType.Variable variableType = variable.getVariableType();
         if( variableType == null ) {
            return namedVariable;
         }

         final J.Identifier identifier = variable.getName();
         final JavaType.Variable fieldType = identifier.getFieldType();
         if( fieldType == null ) {
            return namedVariable;
         }

         if( !Objects.equals( before, identifier.getSimpleName() ) ) {
            return namedVariable;
         }

         final J.Identifier myChangedSimpleName =
            identifier.withSimpleName( after ).withFieldType( fieldType.withName( after ) );
         final J.VariableDeclarations.NamedVariable myChangedVariable =
            variable.withName( myChangedSimpleName ).withVariableType( variableType.withName( after ) );

         final JavaType owner = variableType.getOwner();
         if(owner != null) {
            cursor.putMessageOnFirstEnclosing( J.ClassDeclaration.class, "OWNER", owner );
         }

         return super.visitVariable( myChangedVariable, ctx );
      }

      @Override
      public J.Identifier visitIdentifier(
         final J.Identifier identifier,
         final ExecutionContext ctx )
      {
         final J.Identifier visitedIdentifier = super.visitIdentifier( identifier, ctx );
         if( !Objects.equals( before, identifier.getSimpleName() ) ) {
            return visitedIdentifier;
         }

         final Cursor cursor = getCursor();
         final JavaType.Variable fieldType = identifier.getFieldType();
         if( fieldType == null ) {
            return visitedIdentifier;
         }

         final JavaType owner = fieldType.getOwner();
         final JavaType fieldOwner = cursor.getNearestMessage( "OWNER" );
         if( !Objects.equals( fieldOwner, owner ) ) {
            return visitedIdentifier;
         }

         final J.Identifier myChangedSimpleName =
            identifier.withSimpleName( after ).withFieldType( fieldType.withName( after ) );

         return super.visitIdentifier( myChangedSimpleName, ctx );
      }
   }
}
