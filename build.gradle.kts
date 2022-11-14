

plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.androidApplication).version(Build.gradleBuildTools).apply(false)
    id(Plugins.androidLibrary).version(Build.gradleBuildTools).apply(false)
    kotlin(KotlinPlugins.android).version(Kotlin.version).apply(false)
    kotlin(KotlinPlugins.multiplatform).version(Kotlin.version).apply(false)
}
buildscript {
    dependencies {
        classpath(Build.sqlDelightGradlePlugin)
        classpath(Build.hiltGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
