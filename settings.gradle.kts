pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Krokapp_Mobile_Multiplatform"
include(":androidApp")
include(":shared:data")
include(":shared:domain")
include(":shared:presentation")