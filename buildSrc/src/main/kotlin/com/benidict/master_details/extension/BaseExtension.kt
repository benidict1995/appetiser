package com.benidict.master_details.extension

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import com.benidict.master_details.configuration.AndroidConfig
import com.benidict.master_details.configuration.BuildConfig

internal fun BaseExtension.androidConfigPlugin(){

    compileSdkVersion(AndroidConfig.compileSdk)
    defaultConfig{
        minSdkVersion (AndroidConfig.minSdk)
        targetSdkVersion (AndroidConfig.targetSdk)
        testInstrumentationRunner = AndroidConfig.androidJunitRunner
    }

    buildTypes {
        getByName(BuildConfig.Release.buildTypes){
            buildConfigField("String", "BASE_URL", BuildConfig.Api.baseUrl)
            isMinifyEnabled = BuildConfig.Release.minified
            consumerProguardFiles("consumer-rules.pro")
        }

        getByName(BuildConfig.Debug.buildTypes){
            buildConfigField("String", "BASE_URL", BuildConfig.Api.baseUrl)
            isMinifyEnabled = BuildConfig.Debug.minified
        }
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}