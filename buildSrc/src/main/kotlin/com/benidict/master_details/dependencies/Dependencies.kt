package com.benidict.master_details.dependencies

object Dependencies{

    object SupportDependencies{
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object CommonDependencies{
        const val coroutinesAndroidX = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidX}"

        const val roomKotlin = "androidx.room:room-ktx:${Versions.roomKotlin}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomKotlin}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomKotlin}"

        const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"

        const val koinAndroid = "org.koin:koin-android:${Versions.koinAndroidX}"
        const val koinScopeAndroidX = "org.koin:koin-androidx-scope:${Versions.koinAndroidX}"
        const val koinViewModelAndroidX = "org.koin:koin-androidx-viewmodel:${Versions.koinAndroidX}"
        const val koinFragmentAndroidX = "org.koin:koin-androidx-fragment:${Versions.koinAndroidX}"

        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"

        const val liveDataAndroidx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"

        const val navFragmentAndroidX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationAndroidX}"
        const val navUIAndroidX = "androidx.navigation:navigation-ui-ktx:${Versions.navigationAndroidX}"

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

        const val circularImageView = "de.hdodenhof:circleimageview:${Versions.circularImageView}"

        const val gson = "com.google.code.gson:gson:${Versions.gson}"

        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

        const val retrofitSerializerConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerializer}"
    }

    object TestDependencies{
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }

}