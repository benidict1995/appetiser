package com.benidict.master_details.dependencies

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.commonDependencies() = dependencies{
    add ("implementation", (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))))

    add("implementation", Dependencies.SupportDependencies.kotlinStd)
    add("implementation", Dependencies.SupportDependencies.kotlinCore)
    add("implementation", Dependencies.SupportDependencies.material)

    add("implementation", Dependencies.CommonDependencies.epoxy)
    add("kapt", Dependencies.CommonDependencies.epoxyProcessor)

    add("implementation", Dependencies.CommonDependencies.glide)
    add("kapt", Dependencies.CommonDependencies.glideCompiler)

    add("implementation", Dependencies.CommonDependencies.liveDataAndroidx)

    add("implementation", Dependencies.CommonDependencies.coroutinesAndroidX)

    add("implementation", Dependencies.CommonDependencies.navFragmentAndroidX)
    add("implementation", Dependencies.CommonDependencies.navUIAndroidX)

    add("implementation", Dependencies.CommonDependencies.retrofit)
    add("implementation", Dependencies.CommonDependencies.retrofitSerializerConverter)
    add("implementation", Dependencies.CommonDependencies.okHttp)
    add("implementation", Dependencies.CommonDependencies.okHttpInterceptor)

    add("implementation", Dependencies.CommonDependencies.roomKotlin)
    add("implementation", Dependencies.CommonDependencies.roomRuntime)
    add("kapt", Dependencies.CommonDependencies.roomCompiler)

    add("implementation", Dependencies.CommonDependencies.koinFragmentAndroidX)
    add("implementation", Dependencies.CommonDependencies.koinScopeAndroidX)
    add("implementation", Dependencies.CommonDependencies.koinViewModelAndroidX)
    add("implementation", Dependencies.CommonDependencies.koinAndroid)

    add("implementation", Dependencies.CommonDependencies.gson)

    add("implementation", Dependencies.TestDependencies.junit)
    add("implementation", Dependencies.TestDependencies.extJunit)
    add("implementation", Dependencies.TestDependencies.espressoCore)
}