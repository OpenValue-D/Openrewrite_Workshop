# Situation

We have an old utils library and want to clean it up and update the tests to Junit4.

## TODO 1

- integrate the openrewrite gradle plugin
- choose the proper recipe to remove unused imports (simple recipe)
- execute a rewrite dry run and apply the resulting patch file
    - before applying the patch commit your changes to a local branch!
    - examine the results
- revert the changes
- execute rewrite run
    - examine results

## TODO 2

- choose the proper recipe to migrate from JUnit 4 to 5 (composite recipe)
- run rewrite and examine the results

## TODO 3

- there is a typo in the package name
- choose the proper recipe to rename the package
- create a rewrite.yml with a custom recipe containing the configuration for the rename package recipe
- run the custom recipe and examine the results
