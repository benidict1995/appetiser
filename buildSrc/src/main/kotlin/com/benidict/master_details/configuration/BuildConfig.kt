package com.benidict.master_details.configuration

object BuildConfig {
    const val proguardRules = "proguard-rules.pro"

    object Release{
        const val buildTypes = "release"
        const val minified = true
        const val proguardFilesDefault = "proguard-android-optimize.txt"
    }

    object Debug{
        const val buildTypes = "debug"
        const val minified = false
    }

    object Api{

        //debug
        const val baseUrl = "\"https://itunes.apple.com/\""

        //release
        const val baseUrlRelease = ""
    }
}