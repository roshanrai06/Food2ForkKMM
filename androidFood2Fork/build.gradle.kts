plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    namespace = "com.roshan.dev.food2forkkmm.android"
    compileSdk = Application.compileSdk
    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Coil.coil)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.fragmentKtx)
    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)
    implementation(Google.material)


    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltDaggerCompiler)
    kapt(Hilt.hiltAndroidXCompiler)
    implementation(Hilt.hiltNavigationCompose)
    implementation(AndroidX.navigationCompose)

    implementation(Kotlinx.datetime)
    implementation(Ktor.android)
    debugImplementation(SquareUp.leakCanary)
}