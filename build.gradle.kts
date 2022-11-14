plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Build.gradleBuildTools).apply(false)
    id("com.android.library").version(Build.gradleBuildTools).apply(false)
    kotlin("android").version(Kotlin.version).apply(false)
    kotlin("multiplatform").version(Kotlin.version).apply(false)
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
