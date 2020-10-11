plugins{
    id("com.android.library")
    id("com.benidict.master_details.plugin")
}

android {
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":domain"))
}
