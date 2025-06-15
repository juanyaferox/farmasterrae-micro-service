
plugins {
    id("java-library")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    api("jakarta.validation:jakarta.validation-api")
    api("com.fasterxml.jackson.core:jackson-annotations")
}