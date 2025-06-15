dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(platform(libs.spring.cloud.dependencies))
    // --- Herramientas para Código Limpio y Moderno ---
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    compileOnly(libs.mapstruct.core)
    annotationProcessor(libs.mapstruct.processor)

    // --- Dependencias de Testeo ---
    testImplementation(libs.spring.boot.starter.test)
    //testRuntimeOnly(libs.junit.platform.launcher)
}
