import com.vanniktech.maven.publish.KotlinMultiplatform
import extension.config

plugins {
    alias(libs.plugins.neoutils.core)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    jvm()

    js(IR) {
        browser()
        binaries.library()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":highlight:core"))

            implementation(compose.runtime) {
                because("remember extensions")
            }

            implementation(compose.ui) {
                because("AnnotatedString, SpanStyle, TextFieldValue, Color")
            }
        }
    }
}

android {
    namespace = config.module(name = "compose")

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-compose",
    )

    configure(
        KotlinMultiplatform(
            sourcesJar = true,
            androidVariantsToPublish = listOf("release"),
        )
    )

    pom {
        name.set("Highlight for Compose")
        description.set("Compose patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}