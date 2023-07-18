plugins {
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.kotlinAndroid.get().pluginId) apply false
    id(libs.plugins.org.jetbrains.kotlin.jvm.get().pluginId) apply false
    id(libs.plugins.androidLibrary.get().pluginId) apply false
}
