plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

group = "com.neoutils.highlight.example"
version = "1.0.0"

kotlin {
    jvmToolchain(
        jdkVersion = 17
    )
}

dependencies {

    implementation(project(":highlight:compose"))

    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.ui)
    implementation(compose.material3)

    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            packageName = "desktop"
            packageVersion = "1.0.0"
        }
    }
}
