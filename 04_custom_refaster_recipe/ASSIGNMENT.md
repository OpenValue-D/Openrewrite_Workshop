# Situation

We have a code base that contains ternary operators with boolean as a result. This can be simplified
to the boolean expression of the ternary operation which increases readability and maintainability.

Example:
```java
public boolean isEven(int number) {
   return number % 2 == 0 ? true : false;
}
```
can be simplified to:
```java
public boolean isEven(int number) {
   return number % 2 == 0;
}
```

## TODO 1

- Write a refaster template class, that is capable of simplifying the ternary operator as described in the situation section.
- Use this refaster recipe to make the given test in the class `RefasterTest` pass

### Hint

- You cannot use the refaster class directly, but openrewrite will generate a recipe out of the refaster template.
  - The name of the Class is `<refaster-template-class-name>Recipe`
