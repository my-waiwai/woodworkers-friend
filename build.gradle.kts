// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply{
        set("compose_compiler_version", "1.5.8")
        set("dagger_version", "2.50")
        set("hilt_version", "2.52")
    }
    dependencies {
        val hiltVersion = rootProject.extra.get("hilt_version") as String
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}