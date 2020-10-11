import com.benidict.master_details.dependencies.Dependencies.CommonDependencies.circularImageView
import com.benidict.master_details.dependencies.Dependencies.CommonDependencies.swipeRefresh

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
    implementation(circularImageView)
    implementation(swipeRefresh)

    implementation(project(":domain"))
    implementation(project(":android:core"))
}
