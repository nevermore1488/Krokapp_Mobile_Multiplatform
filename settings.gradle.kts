pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "Krokapp_Mobile_Multiplatform"
include(":androidApp")
include(":shared:data")
include(":shared:domain")
include(":shared:presentation")

dependencyResolutionManagement {

    versionCatalogs {

        create("sharedLibs") {
            from(files("gradle/sharedLibs.versions.toml"))
        }
    }
}