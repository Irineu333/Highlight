import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import extension.config

plugins {
    alias(libs.plugins.neoutils.core)
}

android {
    namespace = config.module(name = "view")
}

dependencies {
    api(project(":highlight:core"))

    api(libs.androidx.appcompat)
    api(libs.neoutils.xregex)
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-view"
    )

    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = false,
        )
    )

    pom {
        name.set("Highlight for View")
        description.set("View-based patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}