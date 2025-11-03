import com.vanniktech.maven.publish.KotlinMultiplatform
import extension.config

plugins {
    alias(libs.plugins.neoutils.core)
}

kotlin {

    jvm()

    js(IR) {
        browser()
        binaries.library()
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.androidx.annotation)
            api(libs.neoutils.xregex)
        }
    }
}

android {
    namespace = config.module(name = "core")
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-core"
    )

    configure(
        KotlinMultiplatform(
            sourcesJar = true,
            androidVariantsToPublish = listOf("release"),
        )
    )

    pom {
        name.set("Highlight")
        description.set("Patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}