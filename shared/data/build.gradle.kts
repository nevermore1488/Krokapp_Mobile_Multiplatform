plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.6.10"
    id("com.squareup.sqldelight")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "data"
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(project(":shared:domain"))

                implementation(sharedLibs.ktor)
                implementation(sharedLibs.coroutines)
                implementation(sharedLibs.kotlinXSerialization)
                implementation(sharedLibs.sqlDelight)
                implementation(sharedLibs.sqlDelightExtensions)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(sharedLibs.ktorAndroid)
                implementation(sharedLibs.sqlDelightAndroid)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(sharedLibs.ktorIos)
                implementation(sharedLibs.sqlDelightIos)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "by.ssrlab.krokapp.mobile.shared.cache"
    }
}
