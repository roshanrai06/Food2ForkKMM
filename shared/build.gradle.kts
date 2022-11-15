plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosFood2Fork/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Ktor.core)
                implementation(Ktor.clientSerialization)
                implementation(Ktor.clientSerializationJson)
                implementation(Ktor.ktorContentNegotiation)
                implementation(SQLDelight.runtime)
                implementation(Kotlinx.datetime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.android)
                implementation(SQLDelight.androidDriver)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation(Ktor.ios)
                implementation(SQLDelight.nativeDriver)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
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
sqldelight {
    database("RecipeDatabase") {
        packageName = "com.roshan.dev.food2forkkmm.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}
android {
    namespace = "com.roshan.dev.food2forkkmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}