# Situation

We want to create an own recipe library to make it easier to run the same recipes everywhere with a single activeRecipe.
This library will contain only a declarative library. It has already a skeleton for a recipe-library

## TODO 1

- Inspect build.gradle to see needed plugin and BOM dependency
- Add test dependencies to rewrite-test and rewrite-java + rewrite-java-(21,dependencies)
- Add test dependencies to junit juniper
- Create new folder src/main/resources
- Define a yaml in META-INF/rewrite in the resources folder with a recipe containing the following Recipes from 01_intro
  - Remove unused imports
  - Rename package name
  - Migrate Junit 4 to 5
- Create new folder src/test/java
- Create a test in the test folder which implements RewriteTest to check if recipe works

## TODO 2

- Publish library to maven local
- Use published library in 01_intro project instead of the separate recipes