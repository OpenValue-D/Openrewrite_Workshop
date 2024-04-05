plugins {
   java
   `jvm-test-suite`
   idea
   id("org.openrewrite.rewrite") version "6.11.2"
}

allprojects {
   repositories {
      mavenCentral()
      mavenLocal()
   }
}

idea {
   module {
      isDownloadJavadoc = true
      isDownloadSources = true
   }
}

dependencies {
   rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:2.9.0"))
   rewrite("org.openrewrite.recipe:rewrite-testing-frameworks:2.6.0")
}

rewrite {
   activeRecipe("de.openvalue.workshop.GradleMultiModuleFix")
}
