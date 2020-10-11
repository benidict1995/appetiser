import com.benidict.master_details.configuration.AndroidConfig
plugins{
    id("com.android.application")
    id("com.benidict.master_details.plugin")
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)
    buildToolsVersion(AndroidConfig.buildTools)
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(project(":android:splash"))
    implementation(project(":android:core"))
    implementation(project(":android:mainlist"))
    implementation(project(":android:artistdetails"))
}
