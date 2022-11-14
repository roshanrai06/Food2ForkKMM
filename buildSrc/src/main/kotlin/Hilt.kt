object Hilt {
    const val version = "2.44"
    private const val androidxVersion = "1.0.0"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltDaggerCompiler = "com.google.dagger:hilt-compiler:$version"
    const val hiltAndroidXCompiler = "androidx.hilt:hilt-compiler:$androidxVersion"

    private const val hiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

}