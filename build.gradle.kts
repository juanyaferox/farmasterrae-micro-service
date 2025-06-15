plugins {
	java
	alias(libs.plugins.spring.boot) apply false
	alias(libs.plugins.spring.dependency.management)
}

allprojects{
	group = "dev.juanyaferox"
	version = "0.0.1-SNAPSHOT"
	repositories {
		mavenCentral()
	}
}

//subprojects {
//	apply(plugin = "java")
//	apply(plugin = "org.springframework.boot")
//	apply(plugin = "io.spring.dependency-management")
//
//	java {
//		toolchain {
//			languageVersion.set(JavaLanguageVersion.of(21))
//		}
//	}
//
//	repositories {
//		mavenCentral()
//	}
//
//	dependencies {
////		implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
////		implementation(platform(libs.spring.cloud.dependencies))
//		// --- Herramientas para Código Limpio y Moderno ---
//		compileOnly(libs.lombok)
//		annotationProcessor(libs.lombok)
//		compileOnly(libs.mapstruct.core)
//		annotationProcessor(libs.mapstruct.processor)
//
//		// --- Dependencias de Testeo ---
//		testImplementation(libs.spring.boot.starter.test)
//		//testRuntimeOnly(libs.junit.platform.launcher)
//	}
//
//	tasks.withType<Test> {
//		useJUnitPlatform()
//	}
//
//	tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
//		enabled = true
//	}
//}
