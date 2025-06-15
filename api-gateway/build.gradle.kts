plugins {
    id("java-library")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = false
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
}