plugins{
    id("com.android.library")
    id("com.benidict.master_details.plugin")
    id("kotlin-android")
}

android {
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":domain"))

    implementation(project(":android:core"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}
