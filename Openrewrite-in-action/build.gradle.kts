plugins {
   java
   idea
}

repositories {
   maven("https://mvnrepository.com/artifact")
   mavenCentral()
}

idea {
   module {
      isDownloadSources = true
      isDownloadJavadoc = true
   }
}

java {
   sourceCompatibility = JavaVersion.VERSION_1_8
   targetCompatibility = JavaVersion.VERSION_1_8
   toolchain {
      languageVersion = JavaLanguageVersion.of(8)
   }
}

dependencies {
   implementation(platform("org.springframework.boot:spring-boot-dependencies:1.4.7.RELEASE"))

   implementation("org.springframework.boot:spring-boot-starter-web")
   implementation("javax.inject:javax.inject:1")
}
