# Situation

We have a legacy spring boot project and want to update it to the latest spring boot version.

## ToDo 1

- integrate the openrewrite gradle plugin
- choose the proper recipes to get from spring boot version 1.4.7.RELEASE to spring boot version 3
- execute a rewrite dry run and apply the resulting patch file
  - before applying the patch commit your changes to a local branch! 
  - examine the results
- revert the changes
- execute rewrite run
  - examine results

## ToDO 2

- create a custom recipe using a rewrite.yml configuration file
  - integrate the recipes from the build configuration
- add another recipe, that adds the spring boot security starter dependency to our gradle build file
- add another recipe, that upgrade the gradle wrapper to the latest version - we want to use Java 21 :)
