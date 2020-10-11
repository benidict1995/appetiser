// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.6.4")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.0")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}

