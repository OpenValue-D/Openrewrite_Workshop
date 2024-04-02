# Situation

We want to create an own recipe library to make it easier to run the same recipes everywhere with a single activeRecipe.
This library will contain only a declarative library. It has already a skeleton for a recipe-library

## TODO 1

- Inspect build.gradle to see needed plugin and BOM dependency
- Create new folder src/main/resources
- Define a yaml in META-INF/rewrite in the resources folder with a recipe containing the following Recipes from 01_intro
  - Remove unused imports
  - Rename package name
  - Migrate Junit 4 to 5
- Publish library to maven local (see publishToMavenLocal task)

## TODO 2

- Use published library in 01_intro project instead of the separate recipes