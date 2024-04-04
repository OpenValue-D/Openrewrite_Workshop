plugins {
   java
   `jvm-test-suite`
   idea
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
