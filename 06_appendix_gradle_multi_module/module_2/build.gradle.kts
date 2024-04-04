plugins {
   java
   id("org.springframework.boot") version "3.2.4"
}

dependencies {
   implementation(project(":module_1"))
   implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
}
